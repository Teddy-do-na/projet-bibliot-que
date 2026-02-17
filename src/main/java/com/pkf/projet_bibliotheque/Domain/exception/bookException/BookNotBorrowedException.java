package com.pkf.projet_bibliotheque.Domain.exception.bookException;

public class BookNotBorrowedException extends RuntimeException {
    public BookNotBorrowedException(String message) {
        super(message);
    }
}
