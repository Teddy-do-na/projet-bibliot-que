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
import java.util.UUID;

@Repository
public interface JpaLoanRepository extends JpaRepository<LoanEntity, UUID> {
    Optional<LoanEntity> findById(Long id);

    List<LoanEntity> findByMemberId(Long memberId);

    List<LoanEntity> findByBookId(Long bookId);

    boolean existsByMemberIdAndBookIdAndReturnDateIsNull(Long memberId, Long bookId);

    @Query("SELECT l FROM LoanEntity l WHERE l.dueDate < CURRENT_TIMESTAMP AND l.returnDate IS NULL")
    List<LoanEntity> findOverdueLoans();

    void deleteById(Long loanId);

}
