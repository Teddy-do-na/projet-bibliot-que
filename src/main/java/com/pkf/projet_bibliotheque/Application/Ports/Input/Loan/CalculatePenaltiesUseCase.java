package com.pkf.projet_bibliotheque.Application.Ports.Input.Loan;

import java.math.BigDecimal;
import java.util.UUID;

public interface CalculatePenaltiesUseCase {
    BigDecimal calculatePenalties(Long loanId);
}
