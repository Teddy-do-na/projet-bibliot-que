package com.pkf.projet_bibliotheque.Application.Ports.Input.Loan;

import com.pkf.projet_bibliotheque.Domain.model.Loan;

import java.util.UUID;

public interface ReturnBookUseCase {
    Loan returnBook(Long loanId);
}
