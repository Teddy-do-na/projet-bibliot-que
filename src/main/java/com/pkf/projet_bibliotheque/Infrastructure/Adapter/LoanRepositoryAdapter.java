package com.pkf.projet_bibliotheque.Infrastructure.Adapter;

import com.pkf.projet_bibliotheque.Application.Ports.Output.LoanRepository;
import com.pkf.projet_bibliotheque.Domain.model.Loan;
import com.pkf.projet_bibliotheque.Infrastructure.Persistence.Entity.LoanEntity;
import com.pkf.projet_bibliotheque.Infrastructure.Persistence.JPA.JpaLoanRepository;
import com.pkf.projet_bibliotheque.Infrastructure.Persistence.Mapper.LoanEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LoanRepositoryAdapter implements LoanRepository {
    private final JpaLoanRepository jpaLoanRepository;
    private final LoanEntityMapper loanEntityMapper;

    @Override
    public Loan save(Loan loan) {
        LoanEntity loanEntity = loanEntityMapper.toLoanEntity(loan);
        LoanEntity loanSaved = jpaLoanRepository.save(loanEntity);
        return loanEntityMapper.toDomain(loanSaved);
    }

    @Override
    public Optional<Loan> findById(Long id) {
        return jpaLoanRepository.findById(id)
                .map(loanEntityMapper::toDomain);
    }

    @Override
    public List<Loan> findAll() {
        return jpaLoanRepository.findAll()
                .stream()
                .map(loanEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Loan> findByMemberId(Long memberId) {
        return jpaLoanRepository.findByMemberId(memberId)
                .stream()
                .map(loanEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Loan> findByBookId(Long bookId) {
        return jpaLoanRepository.findByBookId(bookId)
                .stream()
                .map(loanEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Loan> findByMemberIdAndReturnDateIsNull(Long memberId) {
        return jpaLoanRepository.findByMemberIdAndReturnDateIsNull(memberId)
                .stream()
                .map(loanEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsByMemberIdAndBookIdAndReturnDateIsNull(Long memberId, Long bookId) {
        return jpaLoanRepository.existsByMemberIdAndBookIdAndReturnDateIsNull(memberId, bookId);
    }

    @Override
    public List<Loan> findOverdueLoans() {
        return jpaLoanRepository.findOverdueLoans()
                .stream()
                .map(loanEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public long countActiveByMemberId(Long memberId) {
        return jpaLoanRepository.countActiveByMemberId(memberId);
    }

    @Override
    public long countActiveByBookId(Long bookId) {
        return jpaLoanRepository.countActiveByBookId(bookId);
    }

    @Override
    public void deleteById(Long loanId) {
        jpaLoanRepository.deleteById(loanId);
    }

    @Override
    public void updateReturnDate(Long loanId, LocalDateTime returnDate) {
        jpaLoanRepository.updateReturnDate(loanId, returnDate);
    }

    @Override
    public void updatePenalty(Long loanId, BigDecimal penalty) {
        jpaLoanRepository.updatePenalty(loanId, penalty);
    }
}
