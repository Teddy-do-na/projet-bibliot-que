package com.pkf.projet_bibliotheque.Application.Services.Book;

import com.pkf.projet_bibliotheque.Application.Ports.Input.Book.ListBookUseCase;
import com.pkf.projet_bibliotheque.Application.Ports.Output.BookRepository;
import com.pkf.projet_bibliotheque.Domain.model.Book;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ListBookService implements ListBookUseCase {
    private final BookRepository bookRepository;

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
}
