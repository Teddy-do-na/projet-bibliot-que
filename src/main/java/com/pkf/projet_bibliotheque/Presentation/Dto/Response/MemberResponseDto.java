package com.pkf.projet_bibliotheque.Presentation.Dto.Response;

import java.time.LocalDateTime;
import java.util.UUID;

public record MemberResponseDto(
         Long id,
         String name,
         String firstName,
         String email,
         LocalDateTime adhesionDate
) {

}