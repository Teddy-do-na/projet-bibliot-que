package com.pkf.projet_bibliotheque.Presentation.Dto.Request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookRequestDto(
        @NotBlank(message = " obligatoire")
        String title,
        @NotBlank(message = " obligatoire")
        String author,
        @NotBlank(message = " obligatoire")
        String category,
        @NotNull
        int totalCopies
) {

}