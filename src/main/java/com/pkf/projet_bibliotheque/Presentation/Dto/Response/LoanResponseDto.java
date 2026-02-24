package com.pkf.projet_bibliotheque.Presentation.Dto.Response;


import lombok.*;

import java.math.BigDecimal;
@Builder
public record LoanResponseDto(
         Long id,
         BigDecimal penalty
) {

}
