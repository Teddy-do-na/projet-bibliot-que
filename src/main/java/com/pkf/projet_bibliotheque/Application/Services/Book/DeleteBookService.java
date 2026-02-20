package com.pkf.projet_bibliotheque.Application.Services.Book;

import com.pkf.projet_bibliotheque.Application.Ports.Input.Book.DeleteBookUseCase;
import com.pkf.projet_bibliotheque.Application.Ports.Output.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteBookService implements DeleteBookUseCase {
    private final BookRepository bookRepository;

    @Override
    public Void deleteBook(Long id) {
        bookRepository.deleteById(id);
        return null;
    }
}
