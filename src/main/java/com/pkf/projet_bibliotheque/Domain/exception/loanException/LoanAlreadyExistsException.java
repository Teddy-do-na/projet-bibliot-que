package com.pkf.projet_bibliotheque.Domain.exception.loanException;

public class LoanAlreadyExistsException extends RuntimeException {
    public LoanAlreadyExistsException(String message) {
        super(message);
    }
}
