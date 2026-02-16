package com.pkf.projet_bibliotheque.Domain.exception.bookException;

public class BookNotAvailableException extends RuntimeException {
    public BookNotAvailableException(String message) {
        super(message);
    }
}
