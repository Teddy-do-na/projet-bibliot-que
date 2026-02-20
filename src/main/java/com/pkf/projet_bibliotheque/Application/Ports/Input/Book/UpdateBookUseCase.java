package com.pkf.projet_bibliotheque.Application.Ports.Input.Book;

import com.pkf.projet_bibliotheque.Domain.model.Book;

import java.util.UUID;

public interface UpdateBookUseCase {

   Book updateBook(Long id, Book book);
}
