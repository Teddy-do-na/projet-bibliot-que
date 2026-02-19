package com.pkf.projet_bibliotheque.Application.Ports.Input.Book;

import com.pkf.projet_bibliotheque.Domain.model.Book;

public interface UpdateBookUseCase {
    Book updateBook(Long id, Book book);
}
