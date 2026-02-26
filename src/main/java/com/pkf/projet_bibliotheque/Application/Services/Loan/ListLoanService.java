package com.pkf.projet_bibliotheque.Application.Services.Loan;

import com.pkf.projet_bibliotheque.Application.Ports.Input.Loan.ListLoanUseCase;
import com.pkf.projet_bibliotheque.Application.Ports.Output.LoanRepository;
import com.pkf.projet_bibliotheque.Domain.exception.loanException.LoanNotFoundException;
import com.pkf.projet_bibliotheque.Domain.model.Loan;
import com.pkf.projet_bibliotheque.Presentation.Dto.Response.LoanResponseDto;
import com.pkf.projet_bibliotheque.Presentation.Mapper.LoanDtoMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ListLoanService implements ListLoanUseCase {
    private final LoanRepository loanRepository;
    private final LoanDtoMapper loanDtoMapper;

    @Override
    public List<LoanResponseDto> findAllLoans() {
        return loanRepository.findAll()
                .stream()
                .map(loanDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<LoanResponseDto> findLoanByMemberId(Long memberId) {
        return loanRepository.findByMemberId(memberId)
                .stream()
                .map(loanDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<LoanResponseDto> findLoanByBookId(Long bookId) {
        return loanRepository.findByBookId(bookId)
                .stream()
                .map(loanDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<LoanResponseDto> findOverdueLoans() {
        return loanRepository.findOverdueLoans()
                .stream()
                .map(loanDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<LoanResponseDto> findActiveLoans() {
        return loanRepository.findByReturnDateIsNull()
                .stream()
                .map(loanDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Loan findLoanById(Long loanId) {
        return loanRepository.findById(loanId)
                .orElseThrow(() -> new LoanNotFoundException("Prêt non trouvé avec l'id : " + loanId));
    }
}
