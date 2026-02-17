package com.pkf.projet_bibliotheque.Domain.exception.loanException;

public class PenaltyAlreadyPaidException extends RuntimeException {
    public PenaltyAlreadyPaidException(String message) {
        super(message);
    }
}
