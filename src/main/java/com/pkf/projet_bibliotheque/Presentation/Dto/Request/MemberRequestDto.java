package com.pkf.projet_bibliotheque.Presentation.Dto.Request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record MemberRequestDto(
        @NotBlank(message = "obligatoire")
         String name,
        @NotBlank(message = "obligatoire")
         String firstName,
        @Email
        @NotBlank(message = "obligatoire")
         String email,
        @NotBlank(message = "obligatoire")
         LocalDateTime adhesionDate
        ) {
}
