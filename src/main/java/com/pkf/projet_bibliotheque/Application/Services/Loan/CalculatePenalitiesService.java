package com.pkf.projet_bibliotheque.Application.Services.Loan;

import com.pkf.projet_bibliotheque.Application.Ports.Input.Loan.CalculatePenaltiesUseCase;
import com.pkf.projet_bibliotheque.Application.Ports.Output.LoanRepository;
import com.pkf.projet_bibliotheque.Domain.exception.loanException.LoanNotFoundException;
import com.pkf.projet_bibliotheque.Domain.exception.loanException.PenaltyCalculationException;
import com.pkf.projet_bibliotheque.Domain.model.Loan;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class CalculatePenalitiesService implements CalculatePenaltiesUseCase {
    private final LoanRepository loanRepository;
    private static final BigDecimal DAILY_PENALTY = new BigDecimal("0.50");

    @Override
    public BigDecimal calculatePenalties(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new LoanNotFoundException("Pret non trouvé avec l'id " + loanId));

        if (loan.getReturnDate() == null) {
            throw new PenaltyCalculationException("Impossible de calcuker la penalité que le livre n'est pas retourné");
        }

        if (!loan.getReturnDate().isAfter(loan.getDueDate())) {
            return BigDecimal.ZERO;
        }

        long daysLate = Duration.between(loan.getDueDate(), loan.getReturnDate()).toDays();
        if (daysLate <= 0) return BigDecimal.ZERO;

        return DAILY_PENALTY.multiply(BigDecimal.valueOf(daysLate));
    }
}
