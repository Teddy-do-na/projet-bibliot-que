package com.pkf.projet_bibliotheque.Infrastructure.Persistence.JPA;

import com.pkf.projet_bibliotheque.Infrastructure.Persistence.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface JpaMemberRepository extends JpaRepository<MemberEntity, Integer> {
    List<MemberEntity> findByName(String name);
    Optional<MemberEntity> findById(Long id);

    Optional<MemberEntity> findByEmail(String email);

    List<MemberEntity> findByFirstName(String firstName);
    void deleteById(Long id);

    boolean existsById(Long id);
    boolean existsByEmail(String email);
}
