package com.pkf.projet_bibliotheque.Infrastructure.Persistence.Entity;

import com.pkf.projet_bibliotheque.Domain.model.Member;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "loans")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;
    @Column(name = "loan_date", nullable = false)
    private LocalDate loanDate;
    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;
    @Column(name = "return_date")
    private LocalDate returnDate;
    @Column(name = "penalty",precision = 10,scale = 2,nullable = false)
    private BigDecimal penalty;
    @Column(name = "renewal_count")
    private int renewalCount;

}