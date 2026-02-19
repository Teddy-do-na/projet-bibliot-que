package com.pkf.projet_bibliotheque.Infrastructure.Persistence.Mapper;

import com.pkf.projet_bibliotheque.Domain.model.Loan;
import com.pkf.projet_bibliotheque.Infrastructure.Persistence.Entity.LoanEntity;
import org.mapstruct.Mapper;

@Mapper
public interface LoanEntityMapper {
    LoanEntity toLoanEntity(Loan loan);
    Loan toDomain(LoanEntity loanEntity);
}
