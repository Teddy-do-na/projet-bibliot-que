package com.pkf.projet_bibliotheque.Application.Ports.Input.Loan;

import com.pkf.projet_bibliotheque.Domain.model.Loan;

import java.util.List;
import java.util.UUID;

public interface ListLoanUseCase {
    List<Loan> findAllLoans();;
    List<Loan> findLoanByMemberId(Long memberId);
    List<Loan> findLoanByBookId(Long bookId);

    List<Loan> findActiveLoans();
    List<Loan> findOverdueLoans();
}
