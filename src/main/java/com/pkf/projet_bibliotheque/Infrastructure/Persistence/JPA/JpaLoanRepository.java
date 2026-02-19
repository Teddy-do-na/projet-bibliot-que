package com.pkf.projet_bibliotheque.Infrastructure.Persistence.JPA;

import com.pkf.projet_bibliotheque.Domain.model.Loan;
import com.pkf.projet_bibliotheque.Infrastructure.Persistence.Entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.net.http.HttpHeaders;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface JpaLoanRepository extends JpaRepository<LoanEntity, Integer> {
    Optional<LoanEntity> findById(Long id);

    List<LoanEntity> findByMemberId(Long memberId);

    List<LoanEntity> findByBookId(Long bookId);

    List<LoanEntity> findByMemberIdAndReturnDateIsNull(Long memberId);

    boolean existsByMemberIdAndBookIdAndReturnDateIsNull(Long memberId, Long bookId);

    @Query("SELECT l FROM LoanEntity l WHERE l.dueDate < CURRENT_TIMESTAMP AND l.returnDate IS NULL")
    List<LoanEntity> findOverdueLoans();

    @Query("SELECT COUNT(l) FROM LoanEntity l WHERE l.memberId = :memberId AND l.returnDate IS NULL")
    long countActiveByMemberId(Long memberId);

    @Query("SELECT COUNT(l) FROM LoanEntity l WHERE l.bookId = :bookId AND l.returnDate IS NULL")
    long countActiveByBookId(Long bookId);

    void deleteById(Long loanId);

    @Modifying
    @Query("UPDATE LoanEntity l SET l.returnDate = :returnDate WHERE l.id = :loanId")
    void updateReturnDate(Long loanId, LocalDateTime returnDate);
    @Modifying
    @Query("UPDATE LoanEntity l SET l.penalty = :penalty WHERE l.id = :loanId")
    void updatePenalty(@Param("loanId") Long loanId, @Param("penalty") BigDecimal penalty);
}
