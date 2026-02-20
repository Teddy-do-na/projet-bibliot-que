package com.pkf.projet_bibliotheque.Application.Services.Loan;

import com.pkf.projet_bibliotheque.Application.Ports.Input.Loan.RenewLoanUseCase;
import com.pkf.projet_bibliotheque.Application.Ports.Output.LoanRepository;
import com.pkf.projet_bibliotheque.Domain.exception.loanException.LoanExpiredException;
import com.pkf.projet_bibliotheque.Domain.exception.loanException.LoanNotFoundException;
import com.pkf.projet_bibliotheque.Domain.model.Loan;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class RenewLoanService implements RenewLoanUseCase {
    private final LoanRepository loanRepository;
    private static final int Max_RENEWALS = 2;
    private static final int RENEWAL_DAYS = 14;

    @Override
    public Loan renewLoan(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new LoanNotFoundException("pret non trouvé avec cette id " + loanId));

        if (loan.getReturnDate() != null) {
            throw new LoanNotFoundException("Impossible de renouveler un pret deja retourné");
        }

        if (loan.getDueDate().isBefore(LocalDateTime.now())){
            throw new LoanExpiredException("Impossible de renouveler un pret expiré");
        }

        loan.setDueDate(loan.getDueDate().plusDays(RENEWAL_DAYS));

        return loanRepository.save(loan);
    }
}
