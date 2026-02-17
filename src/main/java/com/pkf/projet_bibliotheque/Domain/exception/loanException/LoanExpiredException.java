package com.pkf.projet_bibliotheque.Domain.exception.loanException;

public class LoanExpiredException extends RuntimeException {
    public LoanExpiredException(String message) {
        super(message);
    }
}
