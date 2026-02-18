package com.pkf.projet_bibliotheque.Application.Ports.Output;

import com.pkf.projet_bibliotheque.Domain.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book save(Book book);
    Optional<Book> findById(Long id);
    List<Book> findAll();
    void deleteByBookId(Long id);
    boolean existsById(Long id);

}
