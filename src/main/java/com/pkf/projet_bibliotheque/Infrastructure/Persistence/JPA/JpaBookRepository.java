package com.pkf.projet_bibliotheque.Infrastructure.Persistence.JPA;

import com.pkf.projet_bibliotheque.Domain.model.Book;
import com.pkf.projet_bibliotheque.Infrastructure.Persistence.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaBookRepository extends JpaRepository<BookEntity, UUID> {
    Optional<BookEntity> findById(Long id);

    void deleteById(Long id);

    boolean existsById(Long id);
}