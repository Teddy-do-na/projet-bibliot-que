package com.pkf.projet_bibliotheque.Domain.exception.bookException;

public class InvalidBookDataException extends RuntimeException{
    public InvalidBookDataException(String message) {
        super(message);
    }
}
