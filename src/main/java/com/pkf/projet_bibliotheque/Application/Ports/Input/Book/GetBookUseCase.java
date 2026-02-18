package com.pkf.projet_bibliotheque.Application.Ports.Input.Book;


import com.pkf.projet_bibliotheque.Domain.model.Book;

public interface GetBookUseCase {
    Book findByIdBook(Long id);
}
