package com.pkf.projet_bibliotheque.Presentation.Dto.Response;


import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record LoanResponseDto(
        Long id,
        Long memberId,
        Long bookId,
        LocalDate loanDate,
        LocalDate dueDate,
        LocalDate returnDate,
        BigDecimal penalty,
        int renewalCount
) {

}
