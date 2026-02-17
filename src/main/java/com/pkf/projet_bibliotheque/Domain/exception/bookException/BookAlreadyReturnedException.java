package com.pkf.projet_bibliotheque.Domain.exception.bookException;

public class BookAlreadyReturnedException extends RuntimeException {
    public BookAlreadyReturnedException(String message) {
        super(message);
    }
}
