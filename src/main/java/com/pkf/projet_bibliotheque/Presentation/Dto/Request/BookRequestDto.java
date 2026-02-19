package com.pkf.projet_bibliotheque.Presentation.Dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// DTO pour les requêtes (création ou mise à jour)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDto {
    private String title;
    private String author;
    private String category;
    private int totalCopies;
}