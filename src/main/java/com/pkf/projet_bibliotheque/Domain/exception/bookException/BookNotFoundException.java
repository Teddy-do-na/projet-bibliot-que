package com.pkf.projet_bibliotheque.Domain.exception.bookException;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}
