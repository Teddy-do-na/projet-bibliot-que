package com.pkf.projet_bibliotheque.Presentation.Dto.Request;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record LoanRequestDto (
        @NotBlank(message = "obligatoire")
        Long memberId,
        @NotBlank(message = "obligatoire")
        Long bookId,
        @NotBlank(message = "obligatoire")
        LocalDateTime loanDate,
        @NotBlank(message = "obligatoire")
        LocalDateTime dueDate,
        @NotBlank(message = "obligatoire")
        LocalDateTime returnDate,
        @NotBlank(message = "obligatoire")
        BigDecimal penalty
){
}