package com.pkf.projet_bibliotheque.Application.Ports.Input.Book;

import com.pkf.projet_bibliotheque.Domain.model.Book;

import java.util.List;

public interface ListBookUseCase {
    List<Book> findAllBooks();
}
