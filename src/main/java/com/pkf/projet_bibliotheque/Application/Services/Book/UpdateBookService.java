package com.pkf.projet_bibliotheque.Application.Services.Book;

import com.pkf.projet_bibliotheque.Application.Ports.Input.Book.UpdateBookUseCase;
import com.pkf.projet_bibliotheque.Application.Ports.Output.BookRepository;
import com.pkf.projet_bibliotheque.Domain.exception.bookException.BookNotFoundException;
import com.pkf.projet_bibliotheque.Domain.model.Book;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateBookService implements UpdateBookUseCase {
    private final BookRepository bookRepository;


    @Override
    public Book updateBook(Long id, Book book) {
        Book updatedBook = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Livre non trouvé avec cette id : " + id));
        if (book.getTitle() != null) updatedBook.setTitle(book.getTitle());
        if (book.getAuthor() != null) updatedBook.setAuthor(book.getAuthor());
        if (book.getCategory() != null) updatedBook.setCategory(book.getCategory());
        if (book.getTotalCopies() != 0)  updatedBook.setTotalCopies(book.getTotalCopies());

        return bookRepository.save(updatedBook);
    }
}
