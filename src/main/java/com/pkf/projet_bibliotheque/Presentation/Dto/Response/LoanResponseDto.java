package com.pkf.projet_bibliotheque.Presentation.Dto.Response;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public record LoanResponseDto(
         Long id,
         Long memberId,
         Long bookId,
         LocalDateTime loanDate,
         LocalDateTime dueDate,
         LocalDateTime returnDate,
         BigDecimal penalty
) {

}
