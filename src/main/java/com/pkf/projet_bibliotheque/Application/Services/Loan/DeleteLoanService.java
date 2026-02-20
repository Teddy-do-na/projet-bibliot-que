package com.pkf.projet_bibliotheque.Application.Services.Loan;

import com.pkf.projet_bibliotheque.Application.Ports.Input.Loan.DeleteLoanUseCase;
import com.pkf.projet_bibliotheque.Application.Ports.Output.LoanRepository;
import com.pkf.projet_bibliotheque.Domain.exception.loanException.LoanNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteLoanService implements DeleteLoanUseCase {
    private final LoanRepository loanRepository;

    @Override
    public void deleteLoan(Long loanId) {
        if (!loanRepository.existsById(loanId)){
            throw new LoanNotFoundException("pret non trouvé avec l'id " + loanId);
        }
        loanRepository.deleteById(loanId);
    }
}
