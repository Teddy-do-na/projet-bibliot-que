package com.pkf.projet_bibliotheque.Presentation.Dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record LoanRequestDto (
        @NotNull(message = "Member ID est obligatoire")
        Long memberId,
        @NotNull(message = "Book ID est obligatoire")
        Long bookId,
        @NotNull(message = "La date d'emprunt est obligatoire")
        LocalDate loanDate
){
}