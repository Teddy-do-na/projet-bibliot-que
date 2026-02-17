package com.pkf.projet_bibliotheque.Domain.exception.memberException;

public class InvalidMemberDataException extends RuntimeException {
    public InvalidMemberDataException(String message) {
        super(message);
    }
}
