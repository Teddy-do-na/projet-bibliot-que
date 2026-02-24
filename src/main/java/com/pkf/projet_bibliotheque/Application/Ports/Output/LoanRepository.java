package com.pkf.projet_bibliotheque.Application.Ports.Output;

import com.pkf.projet_bibliotheque.Domain.model.Loan;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LoanRepository {
    Loan save(Loan loan);

    Optional<Loan> findById(Long id);
    List<Loan> findAll();
    List<Loan> findByMemberId(Long memberId);
    List<Loan> findByBookId(Long bookId);
    boolean existsByMemberIdAndBookIdAndReturnDateIsNull(Long memberId, Long bookId);
    long countActiveByMemberId(Long memberId);
    long countActiveByBookId(Long bookId);
    void deleteById(Long loanId);
    boolean existsById(Long loanId);
    @Query("SELECT l FROM Loan l WHERE l.returnDate IS NULL")
    List<Loan> findOverdueLoans();
    List<Loan> findByReturnDateIsNull();
}
