package com.pkf.projet_bibliotheque.Application.Ports.Output;
import com.pkf.projet_bibliotheque.Domain.model.Loan;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface LoanRepository {
    Loan save(Loan loan);
    Optional<Loan> findById(Long id);
    List<Loan> findAll();
    List<Loan> findByMemberId(Long memberId);
    List<Loan> findByBookId(Long bookId);
    List<Loan> findByLoanDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<Loan> findByDueDateBefore(LocalDateTime date);
    List<Loan> findByReturnDateIsNull();
    List<Loan> findByReturnDateIsNotNull();
    List<Loan> findByPenaltyGreaterThan(java.math.BigDecimal minPenalty);
    List<Loan> findActiveLoansByMemberId(Long memberId);
    List<Loan> findOverdueLoans();
    void deleteById(Long id);
    boolean existsById(Long id);
    long count();
    long countActiveLoansByMemberId(Long memberId);
    void updateReturnDate(Long loanId, LocalDateTime returnDate);
    void updatePenalty(Long loanId, java.math.BigDecimal penalty);
}