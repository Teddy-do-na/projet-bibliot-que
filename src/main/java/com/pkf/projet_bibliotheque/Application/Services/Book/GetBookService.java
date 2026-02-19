package com.pkf.projet_bibliotheque.Application.Services.Book;

import com.pkf.projet_bibliotheque.Application.Ports.Input.Book.GetBookUseCase;
import com.pkf.projet_bibliotheque.Application.Ports.Output.BookRepository;
import com.pkf.projet_bibliotheque.Domain.model.Book;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class GetBookService implements GetBookUseCase {
    private final BookRepository bookRepository;


    @Override
    public Optional<Book> findByIdBook(Long id) {
        return bookRepository.findById(id);
    }
}
