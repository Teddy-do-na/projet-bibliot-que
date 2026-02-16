package com.pkf.projet_bibliotheque.Domain.exception.bookException;

public class BookAlreadyBorrowedException extends RuntimeException {
    public BookAlreadyBorrowedException(String message) {
        super(message);
    }
}
