package com.pkf.projet_bibliotheque.Application.Ports.Input.Book;


import com.pkf.projet_bibliotheque.Domain.model.Book;

import java.util.Optional;
import java.util.UUID;

public interface GetBookUseCase {

    Optional<Book> findByIdBook(Long id);
}
