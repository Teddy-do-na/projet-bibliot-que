package com.pkf.projet_bibliotheque.Infrastructure.Persistence.Entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Member")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MemberEntity {

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "Name", columnDefinition = "TEXT")
    private String name;
    @Column(name = "FirtName")
    private String firstname;
    @Column(name = "Email")
    private String email;
    @Column(name = "adhesionDate")
    private LocalDateTime adhesionDate;






}
