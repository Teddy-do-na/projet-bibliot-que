package com.pkf.projet_bibliotheque.Application.Services.Loan;

import com.pkf.projet_bibliotheque.Application.Ports.Input.Loan.ListLoanUseCase;
import com.pkf.projet_bibliotheque.Application.Ports.Output.LoanRepository;
import com.pkf.projet_bibliotheque.Domain.model.Loan;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ListLoanService implements ListLoanUseCase {
    private final LoanRepository loanRepository;

    @Override
    public List<Loan> findAllLoans() {
        return loanRepository.findAll();
    }

    @Override
    public List<Loan> findLoanByMemberId(Long memberId) {
        return loanRepository.findByMemberId(memberId);
    }

    @Override
    public List<Loan> findLoanByBookId(Long bookId) {
        return loanRepository.findByBookId(bookId);
    }

    @Override
    public List<Loan> findActiveLoans() {
        return loanRepository.findByReturnDateIsNull();

    }

    @Override
    public List<Loan> findOverdueLoans() {
        return loanRepository.findOverdueLoans();
    }
}
