package com.pkf.projet_bibliotheque.Domain.exception.loanException;

public class MaximumRenewalsExceededException extends RuntimeException {
    public MaximumRenewalsExceededException(String message) {
        super(message);
    }
}
