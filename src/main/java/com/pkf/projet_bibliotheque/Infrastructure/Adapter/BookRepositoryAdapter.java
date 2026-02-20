package com.pkf.projet_bibliotheque.Infrastructure.Adapter;

import com.pkf.projet_bibliotheque.Application.Ports.Output.BookRepository;
import com.pkf.projet_bibliotheque.Domain.model.Book;
import com.pkf.projet_bibliotheque.Infrastructure.Persistence.Entity.BookEntity;
import com.pkf.projet_bibliotheque.Infrastructure.Persistence.JPA.JpaBookRepository;
import com.pkf.projet_bibliotheque.Infrastructure.Persistence.Mapper.BookEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
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
    public void deleteById(Long id) {
        jpaBookRepository.deleteById(id);;
    }


}
