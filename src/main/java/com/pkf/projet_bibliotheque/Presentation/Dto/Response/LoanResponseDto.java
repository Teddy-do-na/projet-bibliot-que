package com.pkf.projet_bibliotheque.Presentation.Dto.Response;


import java.math.BigDecimal;
import java.util.UUID;

public record LoanResponseDto(
         Long id,
         BigDecimal penalty
) {

}
