package com.pkf.projet_bibliotheque.Application.Services.Loan;

import com.pkf.projet_bibliotheque.Application.Ports.Input.Loan.CalculatePenaltiesUseCase;
import com.pkf.projet_bibliotheque.Application.Ports.Input.Loan.ReturnBookUseCase;
import com.pkf.projet_bibliotheque.Application.Ports.Output.LoanRepository;
import com.pkf.projet_bibliotheque.Domain.exception.bookException.BookAlreadyReturnedException;
import com.pkf.projet_bibliotheque.Domain.exception.loanException.LoanNotFoundException;
import com.pkf.projet_bibliotheque.Domain.model.Loan;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ReturnBookService implements ReturnBookUseCase {
    private final LoanRepository loanRepository;
    private final CalculatePenaltiesUseCase calculatePenaltiesUseCase;

    @Override
    public Loan returnBook(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new LoanNotFoundException("Pret non trouvé avec cet id " + loanId));

        if (loan.getReturnDate() != null) {
            throw new BookAlreadyReturnedException("Ce livre a deja ete retourné");
        }
        loan.setReturnDate(LocalDate.now());

        if (loan.getReturnDate().isAfter(loan.getDueDate())){
            BigDecimal penalty = calculatePenaltiesUseCase.calculatePenalties(loanId);
            loan.setPenalty(penalty);
        }
        return loanRepository.save(loan);
    }
}
