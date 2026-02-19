package com.pkf.projet_bibliotheque.Infrastructure.Adapter;

import com.pkf.projet_bibliotheque.Application.Ports.Output.BookRepository;
import com.pkf.projet_bibliotheque.Domain.exception.bookException.BookNotFoundException;
import com.pkf.projet_bibliotheque.Domain.model.Book;
import com.pkf.projet_bibliotheque.Infrastructure.Persistence.Entity.BookEntity;
import com.pkf.projet_bibliotheque.Infrastructure.Persistence.JPA.JpaBookRepository;
import com.pkf.projet_bibliotheque.Infrastructure.Persistence.Mapper.BookEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookRepositoryAdapter implements BookRepository {
    private final JpaBookRepository jpaBookRepository;
    private final BookEntityMapper bookEntityMapper;

    @Override
    public Book save(Book book) {
        BookEntity entity = bookEntityMapper.toEntity(book);
        BookEntity savedEntity = jpaBookRepository.save(entity);
        return bookEntityMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return jpaBookRepository.findById(id)
                .map(bookEntityMapper::toDomain);
    }

    @Override
    public List<Book> findAll() {
        return jpaBookRepository.findAll().stream()
                .map(bookEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByTitle(String title) {
        return jpaBookRepository.findByTitle(title).stream()
                .map(bookEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return jpaBookRepository.findByAuthor(author)
                .stream()
                .map(bookEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByCategory(String category) {
        return jpaBookRepository.findByCategory(category)
                .stream()
                .map(bookEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaBookRepository.deleteById(id);;

    }

    @Override
    public boolean existsById(Long id) {
        return jpaBookRepository.existsById(id);
    }

    @Override
    public long count() {
        return jpaBookRepository.count();
    }

    @Override
    public List<Book> findByTotalCopiesGreaterThan(int minCopies) {
        return jpaBookRepository.findByTotalCopiesGreaterThan(minCopies)
                .stream()
                .map(bookEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void updateTotalCopies(Long bookId, int newTotalCopies) {
        BookEntity entity = jpaBookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Livre non trouvé avec l'id " + bookId));
        entity.setTotalCopies(newTotalCopies);
        jpaBookRepository.save(entity);
    }
}
