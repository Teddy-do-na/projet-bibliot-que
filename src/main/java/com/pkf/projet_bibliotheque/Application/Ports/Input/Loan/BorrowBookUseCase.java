package com.pkf.projet_bibliotheque.Application.Ports.Input.Loan;

import com.pkf.projet_bibliotheque.Domain.model.Loan;

import java.time.LocalDateTime;
import java.util.UUID;

public interface BorrowBookUseCase {

    Loan borrowBook(Long memberId, Long bookId, LocalDateTime loanDate);
}
