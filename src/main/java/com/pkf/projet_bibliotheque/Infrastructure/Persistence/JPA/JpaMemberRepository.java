package com.pkf.projet_bibliotheque.Infrastructure.Persistence.JPA;

import com.pkf.projet_bibliotheque.Domain.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMemberRepository extends JpaRepository<Member, Integer> {
}
