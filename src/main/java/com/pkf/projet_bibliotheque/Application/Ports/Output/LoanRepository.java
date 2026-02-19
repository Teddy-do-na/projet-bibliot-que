package com.pkf.projet_bibliotheque.Application.Ports.Output;

import com.pkf.projet_bibliotheque.Domain.model.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanRepository {
    Loan save(Loan loan);

    Optional<Loan> findById(Long id);

    List<Loan> findAll();

    List<Loan> findByMemberId(Long memberId);

    List<Loan> findByBookId(Long bookId);

    List<Loan> findByMemberIdAndReturnDateIsNull(Long memberId);

    boolean existsByMemberIdAndBookIdAndReturnDateIsNull(Long memberId, Long bookId);

    List<Loan> findOverdueLoans();

    long countActiveByMemberId(Long memberId);

    long countActiveByBookId(Long bookId);

    void deleteById(Long loanId);
}
