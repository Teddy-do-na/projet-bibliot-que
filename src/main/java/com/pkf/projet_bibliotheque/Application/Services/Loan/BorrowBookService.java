package com.pkf.projet_bibliotheque.Application.Services.Loan;

import com.pkf.projet_bibliotheque.Application.Ports.Input.Loan.BorrowBookUseCase;
import com.pkf.projet_bibliotheque.Application.Ports.Output.BookRepository;
import com.pkf.projet_bibliotheque.Application.Ports.Output.LoanRepository;
import com.pkf.projet_bibliotheque.Application.Ports.Output.MemberRepository;
import com.pkf.projet_bibliotheque.Domain.exception.bookException.BookNotAvailableException;
import com.pkf.projet_bibliotheque.Domain.exception.bookException.BookNotFoundException;
import com.pkf.projet_bibliotheque.Domain.exception.loanException.BorrowLimitExceededException;
import com.pkf.projet_bibliotheque.Domain.exception.loanException.LoanAlreadyExistsException;
import com.pkf.projet_bibliotheque.Domain.exception.memberException.MemberNotFoundException;
import com.pkf.projet_bibliotheque.Domain.model.Book;
import com.pkf.projet_bibliotheque.Domain.model.Loan;
import com.pkf.projet_bibliotheque.Domain.model.Member;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
@Transactional
public class BorrowBookService implements BorrowBookUseCase {
    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    private static final int MAX_LOANS_PER_MEMBER = 5;
    private static final int DEFAULT_LOAN_DURATION_DAYS = 21;

    @Override
    public Loan borrowBook(Long memberId, Long bookId, LocalDateTime loanDate) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException("Membre non trouvé avec cette id " + memberId));
        long activeLoans = loanRepository.countActiveByMemberId(memberId);
        if (activeLoans >= MAX_LOANS_PER_MEMBER) {
            throw new BorrowLimitExceededException("le membre a deja atteind le nombre maximal de prets(" + MAX_LOANS_PER_MEMBER + ")");
        }
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Livre non trouvé avec cette id " + bookId));

        long activeLoansForBook = loanRepository.countActiveByBookId(bookId);
        if (activeLoansForBook >= book.getTotalCopies()) {
            throw new BookNotAvailableException("aucun exemplaire disponible pour le livre : " + book.getTitle());
        }

        boolean alreadyBorrowed = loanRepository.existsByMemberIdAndBookIdAndReturnDateIsNull(memberId, bookId);
        if (alreadyBorrowed) {
            throw new LoanAlreadyExistsException("Le membre a deja emprunté ce livre et ne l'a pas encore retourné");
        }

        LocalDateTime dueDate = loanDate.plusDays(DEFAULT_LOAN_DURATION_DAYS);
        Loan loan = new Loan();
        loan.setBookId(bookId);
        loan.setLoanDate(loanDate);
        loan.setMemberId(memberId);
        loan.setDueDate(dueDate);
        loan.setReturnDate(null);
        loan.setPenalty(BigDecimal.ZERO);
        Loan savedLoan = loanRepository.save(loan);

        return savedLoan;


    }
}