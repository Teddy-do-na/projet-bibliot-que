package com.pkf.projet_bibliotheque.Presentation.Dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record LoanRequestDto (
        @NotNull(message = "Member ID is required")
        Long memberId,
        @NotNull(message = "Book ID is required")
        Long bookId,
        @NotNull(message = "obligatoire")
        LocalDate loanDate,
        @NotNull(message = "obligatoire")
        LocalDate dueDate,
        @NotNull(message = "obligatoire")
        LocalDate returnDate,
        @NotNull(message = "obligatoire")
        BigDecimal penalty
){
}