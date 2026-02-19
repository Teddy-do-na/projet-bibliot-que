package com.pkf.projet_bibliotheque.Application.Ports.Output;

import com.pkf.projet_bibliotheque.Domain.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book save(Book book);
    Optional<Book> findById(Long id);
    List<Book> findAll();
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByCategory(String category);
    void deleteById(Long id);
    boolean existsById(Long id);
    long count();
    List<Book> findByTotalCopiesGreaterThan(int minCopies);
    void updateTotalCopies(Long bookId, int newTotalCopies);
}