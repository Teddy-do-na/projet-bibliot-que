package com.pkf.projet_bibliotheque.Domain.exception.loanException;

public class BorrowLimitExceededException extends RuntimeException {
    public BorrowLimitExceededException(String message) {
        super(message);
    }
}
