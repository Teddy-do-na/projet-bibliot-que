package com.pkf.projet_bibliotheque.Domain.exception.memberException;

public class MemberAlreadyExistsException extends RuntimeException {
    public MemberAlreadyExistsException(String message) {
        super(message);
    }
}
