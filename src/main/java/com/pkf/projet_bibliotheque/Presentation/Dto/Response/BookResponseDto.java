package com.pkf.projet_bibliotheque.Presentation.Dto.Response;

public record BookResponseDto(
         Long id,
         String title,
         String author,
         String category,
         int totalCopies
) {

}