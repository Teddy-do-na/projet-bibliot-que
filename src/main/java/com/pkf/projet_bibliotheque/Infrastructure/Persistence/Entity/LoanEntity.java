package com.pkf.projet_bibliotheque.Infrastructure.Persistence.Entity;

import com.pkf.projet_bibliotheque.Domain.model.Member;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "loans")  // Correction: table au pluriel et minuscules
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    // CORRECTION: Utiliser BookEntity au lieu de java.awt.print.Book
    @ManyToOne
    @JoinColumn(name = "book_id")  // Convention: book_id plutôt que id_book
    private BookEntity book;  // ← Changé de Book à BookEntity

    // CORRECTION: Utiliser MemberEntity au lieu de Member (si Member est une entité JPA)
    @ManyToOne
    @JoinColumn(name = "member_id")  // Convention: member_id
    private MemberEntity member;  // ← Si MemberEntity existe, sinon à créer

    // Ajoutez les champs manquants pour un prêt
    @Column(name = "loan_date", nullable = false)
    private LocalDate loanDate;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Column(name = "return_date")
    private LocalDate returnDate;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}