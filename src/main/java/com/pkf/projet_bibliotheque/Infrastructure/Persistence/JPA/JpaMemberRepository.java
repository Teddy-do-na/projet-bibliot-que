package com.pkf.projet_bibliotheque.Infrastructure.Persistence.JPA;

import com.pkf.projet_bibliotheque.Infrastructure.Persistence.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface JpaMemberRepository extends JpaRepository<MemberEntity, UUID> {
    Optional<MemberEntity> findById(Long id);
    void deleteById(Long id);

    boolean existsById(Long id);

    boolean existsByEmail(String email);
}
