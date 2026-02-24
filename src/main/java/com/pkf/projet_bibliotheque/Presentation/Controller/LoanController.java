package com.pkf.projet_bibliotheque.Presentation.Controller;

import com.pkf.projet_bibliotheque.Application.Ports.Input.Loan.*;
import com.pkf.projet_bibliotheque.Domain.model.Loan;
import com.pkf.projet_bibliotheque.Presentation.Dto.Request.LoanRequestDto;
import com.pkf.projet_bibliotheque.Presentation.Dto.Response.LoanResponseDto;
import com.pkf.projet_bibliotheque.Presentation.Mapper.LoanDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {
    private final CalculatePenaltiesUseCase calculatePenaltiesUseCase;
    private final BorrowBookUseCase borrowBookUseCase;
    private final DeleteLoanUseCase deleteLoanUseCase;
    private final ListLoanUseCase listLoanUseCase;
    private final RenewLoanUseCase renewLoanUseCase;
    private final ReturnBookUseCase returnBookUseCase;
    private final LoanDtoMapper loanDtoMapper;

    @PostMapping
    public ResponseEntity<LoanResponseDto> borrowBook(@Valid @RequestBody LoanRequestDto loanRequestDto) {

        Loan loan = loanDtoMapper.toDomain(loanRequestDto);

        Loan borrowedLoan = borrowBookUseCase.borrowBook(
                loan.getMemberId(),
                loan.getBookId(),
                LocalDateTime.now()
        );


        return ResponseEntity.ok(loanDtoMapper.toDto(borrowedLoan));
    }

    @PutMapping("/{loanId}/return")
    public ResponseEntity<LoanResponseDto> returnBook(@PathVariable Long loanId) {
        Loan returnedLoan = returnBookUseCase.returnBook(loanId);
        return ResponseEntity.ok(loanDtoMapper.toDto(returnedLoan));
    }

    @PutMapping("/{loanId}/renew")
    public ResponseEntity<LoanResponseDto> renewLoan(@PathVariable Long loanId) {
        Loan renewedLoan = renewLoanUseCase.renewLoan(loanId);
        return ResponseEntity.ok(loanDtoMapper.toDto(renewedLoan));
    }

    @GetMapping("/{loanId}/penalty")
    public ResponseEntity<LoanResponseDto> calculatePenalty(@PathVariable Long loanId) {
        BigDecimal penalty = calculatePenaltiesUseCase.calculatePenalties(loanId);
        return ResponseEntity.ok(new LoanResponseDto(loanId, penalty));
    }

    @GetMapping
    public ResponseEntity<List<LoanResponseDto>> getAllLoans() {
        List<Loan> loans = listLoanUseCase.findAllLoans();
        List<LoanResponseDto> responseDtos = loans.stream()
                .map(loanDtoMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDtos);
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<LoanResponseDto>> getLoansByMemberId(@PathVariable Long memberId) {
        List<Loan> loans = listLoanUseCase.findLoanByMemberId(memberId);
        List<LoanResponseDto> responseDtos = loans.stream()
                .map(loanDtoMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDtos);
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<LoanResponseDto>> getLoansByBookId(@PathVariable Long bookId) {
        List<Loan> loans = listLoanUseCase.findLoanByBookId(bookId);
        List<LoanResponseDto> responseDtos = loans.stream()
                .map(loanDtoMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDtos);
    }

    @GetMapping("/overdue")
    public ResponseEntity<List<LoanResponseDto>> getOverdueLoans() {
        List<Loan> loans = listLoanUseCase.findOverdueLoans();
        List<LoanResponseDto> responseDtos = loans.stream()
                .map(loanDtoMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDtos);
    }

    @GetMapping("/active")
    public ResponseEntity<List<LoanResponseDto>> getActiveLoans() {
        List<Loan> loans = listLoanUseCase.findActiveLoans();
        List<LoanResponseDto> responseDtos = loans.stream()
                .map(loanDtoMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDtos);
    }

    @DeleteMapping("/{loanId}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long loanId) {
        deleteLoanUseCase.deleteLoan(loanId);
        return ResponseEntity.noContent().build();
    }
}
