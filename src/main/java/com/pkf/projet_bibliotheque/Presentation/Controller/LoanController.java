package com.pkf.projet_bibliotheque.Presentation.Controller;

import com.pkf.projet_bibliotheque.Application.Ports.Input.Loan.*;
import com.pkf.projet_bibliotheque.Domain.model.Loan;
import com.pkf.projet_bibliotheque.Presentation.Dto.Request.LoanRequestDto;
import com.pkf.projet_bibliotheque.Presentation.Dto.Response.LoanResponseDto;
import com.pkf.projet_bibliotheque.Presentation.Mapper.LoanDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

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
    public ResponseEntity<Loan> borrowBook(@Valid @RequestBody LoanRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(borrowBookUseCase.borrowBook(dto.memberId(),dto.bookId()));
    }

    @PutMapping("/{loanId}/return")
    public ResponseEntity<Loan> returnBook(@PathVariable Long loanId) {
        return ResponseEntity.ok(returnBookUseCase.returnBook(loanId));
    }

    @PutMapping("/{loanId}/renew")
    public ResponseEntity<Loan> renewLoan(@PathVariable Long loanId) {
        return ResponseEntity.ok(renewLoanUseCase.renewLoan(loanId));
    }

    @GetMapping("/{loanId}/penalty")
    public ResponseEntity<BigDecimal> calculatePenalty(@PathVariable Long loanId) {
        return ResponseEntity.ok(calculatePenaltiesUseCase.calculatePenalties(loanId));
    }

    @GetMapping
    public ResponseEntity<List<LoanResponseDto>> getAllLoans() {
        return ResponseEntity.ok(listLoanUseCase.findAllLoans());
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<LoanResponseDto>> getLoansByMemberId(@PathVariable Long memberId) {
        return ResponseEntity.ok(listLoanUseCase.findLoanByMemberId(memberId));
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<LoanResponseDto>> getLoansByBookId(@PathVariable Long bookId) {
        return ResponseEntity.ok(listLoanUseCase.findLoanByBookId(bookId));
    }

    @GetMapping("/overdue")
    public ResponseEntity<List<LoanResponseDto>> getOverdueLoans() {
        return ResponseEntity.ok(listLoanUseCase.findOverdueLoans());
    }

    @GetMapping("/active")
    public ResponseEntity<List<LoanResponseDto>> getActiveLoans() {
        return ResponseEntity.ok(listLoanUseCase.findActiveLoans());
    }

    @DeleteMapping("/{loanId}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long loanId) {
        deleteLoanUseCase.deleteLoan(loanId);
        return ResponseEntity.noContent().build();
    }
}
