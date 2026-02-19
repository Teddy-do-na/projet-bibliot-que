package com.pkf.projet_bibliotheque.Infrastructure.Persistence.JPA;

import com.pkf.projet_bibliotheque.Infrastructure.Persistence.Entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaLoanRepository extends JpaRepository<LoanEntity, Integer> {
}
