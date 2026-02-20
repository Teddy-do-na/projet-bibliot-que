package com.pkf.projet_bibliotheque.Application.Ports.Output;

import com.pkf.projet_bibliotheque.Domain.model.Loan;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LoanRepository {
    Loan save(Loan loan);

    Optional<Loan> findById(Long id);
    List<Loan> findAll();
    List<Loan> findByMemberId(Long memberId);
    List<Loan> findByBookId(Long bookId);
    boolean existsByMemberIdAndBookIdAndReturnDateIsNull(Long memberId, Long bookId);
    List<Loan> findOverdueLoans();
    long countActiveByMemberId(Long memberId);
    long countActiveByBookId(Long bookId);
    void deleteById(Long loanId);

    boolean existsById(Long loanId);
}
