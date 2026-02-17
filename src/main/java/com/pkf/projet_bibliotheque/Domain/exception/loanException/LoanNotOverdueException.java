package com.pkf.projet_bibliotheque.Domain.exception.loanException;

public class LoanNotOverdueException extends RuntimeException {
    public LoanNotOverdueException(String message) {
        super(message);
    }
}
