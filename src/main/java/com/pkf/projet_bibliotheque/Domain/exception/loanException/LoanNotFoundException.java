package com.pkf.projet_bibliotheque.Domain.exception.loanException;

public class LoanNotFoundException extends RuntimeException {
    public LoanNotFoundException(String message) {
        super(message);
    }
}
