package com.pkf.projet_bibliotheque.Application.Ports.Input.Book;

import java.awt.print.Book;

public interface GetBookUseCase {
    Book findByIdBook(Long id);
}
