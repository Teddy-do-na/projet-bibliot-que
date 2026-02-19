package com.pkf.projet_bibliotheque.Presentation.Dto.Request;


import jakarta.validation.constraints.NotBlank;

public record BookRequestDto(
        @NotBlank(message = " obligatoire")
        String title,
        @NotBlank(message = " obligatoire")
        String author,
        @NotBlank(message = " obligatoire")
        String category,
        @NotBlank(message = " obligatoire")
        int totalCopies
) {

}