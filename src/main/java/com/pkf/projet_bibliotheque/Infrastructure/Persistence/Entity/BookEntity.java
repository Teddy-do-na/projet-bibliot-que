package com.pkf.projet_bibliotheque.Infrastructure.Persistence.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "books")  // Convention: nom de table en minuscules et au pluriel
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "title", nullable = false, length = 200)  // CORRECTION: title au lieu de tile
    private String title;  // CORRECTION: title au lieu de tile

    @Column(name = "author", nullable = false, length = 100)
    private String author;

    @Column(name = "isbn", unique = true, length = 20)  // Ajout optionnel
    private String isbn;

    @Column(name = "category", length = 100)  // category comme String simple
    private String category;

    @Column(name = "total_copies", nullable = false)
    private Integer totalCopies;  // CORRECTION: Integer au lieu de String

    @Column(name = "available_copies", nullable = false)
    private Integer availableCopies;  // Ajout pour savoir combien sont disponibles

    @Column(name = "publication_year")
    private Integer publicationYear;

    @Column(name = "publisher", length = 100)
    private String publisher;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "cover_image_url", length = 500)
    private String coverImageUrl;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (availableCopies == null) {
            availableCopies = totalCopies;  // Par défaut, toutes les copies sont disponibles
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Méthodes métier
    public boolean isAvailable() {
        return availableCopies != null && availableCopies > 0;
    }

    public void borrowOneCopy() {
        if (availableCopies == null || availableCopies <= 0) {
            throw new IllegalStateException("No copies available");
        }
        availableCopies--;
    }

    public void returnOneCopy() {
        if (availableCopies == null) {
            availableCopies = 0;
        }
        if (availableCopies < totalCopies) {
            availableCopies++;
        }
    }
}