package com.pkf.projet_bibliotheque.Domain.exception.loanException;

public class LoanReturnDateBeforeLoanDateException extends RuntimeException {
    public LoanReturnDateBeforeLoanDateException(String message) {
        super(message);
    }
}
