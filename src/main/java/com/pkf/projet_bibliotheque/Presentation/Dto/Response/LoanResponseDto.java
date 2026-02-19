package com.pkf.projet_bibliotheque.Presentation.Dto.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// DTO pour les réponses
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanResponseDto {
    private Long id;
    private Long memberId;
    private Long bookId;
    private LocalDateTime loanDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
    private BigDecimal penalty;
}
