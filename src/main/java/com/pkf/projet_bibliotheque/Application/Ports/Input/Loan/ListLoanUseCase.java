package com.pkf.projet_bibliotheque.Application.Ports.Input.Loan;

import com.pkf.projet_bibliotheque.Domain.model.Loan;
import com.pkf.projet_bibliotheque.Presentation.Dto.Response.LoanResponseDto;

import java.util.List;
import java.util.UUID;

public interface ListLoanUseCase {
    List<LoanResponseDto> findAllLoans();
    List<LoanResponseDto> findLoanByMemberId(Long memberId);
    List<LoanResponseDto> findLoanByBookId(Long bookId);
    List<LoanResponseDto> findOverdueLoans();
    List<LoanResponseDto> findActiveLoans();
    Loan findLoanById(Long loanId);
}
