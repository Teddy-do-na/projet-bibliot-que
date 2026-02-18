package com.pkf.projet_bibliotheque.Application.Ports.Input.Loan;

import java.math.BigDecimal;

public interface CalculatePenaltiesUseCase {
    BigDecimal calculatePenalties(Long loanId);
}
