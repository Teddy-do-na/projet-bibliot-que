package com.pkf.projet_bibliotheque.Infrastructure.Persistence.Entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
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
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = "first_name", length = 50,  nullable = false)
    private String firstName;
    @Column(name = "email",unique = true, length = 100)
    private String email;
    @CreationTimestamp
    @Column(name = "adhesionDate")
    private LocalDateTime adhesionDate;






}
