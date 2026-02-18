package com.pkf.projet_bibliotheque.Application.Ports.Input.Loan;

import com.pkf.projet_bibliotheque.Domain.model.Loan;

import java.time.LocalDateTime;

public interface BorrowBookUseCase {
    Loan borrowBook(Long memberId, Long bookId, LocalDateTime loanDate);
}
