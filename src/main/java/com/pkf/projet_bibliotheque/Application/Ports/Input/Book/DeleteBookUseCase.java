package com.pkf.projet_bibliotheque.Application.Ports.Input.Book;

import java.util.UUID;

public interface DeleteBookUseCase {
    Void deleteBook(Long id);
}
