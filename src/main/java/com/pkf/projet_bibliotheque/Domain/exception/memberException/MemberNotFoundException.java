package com.pkf.projet_bibliotheque.Domain.exception.memberException;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(String message) {
        super(message);
    }
}
