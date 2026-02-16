package com.pkf.projet_bibliotheque.Domain.exception.memberException;

public class MemberSuspendedException extends RuntimeException {
    public MemberSuspendedException(String message) {
        super(message);
    }
}
