package com.pkf.projet_bibliotheque.Infrastructure.Persistence.Mapper;

import com.pkf.projet_bibliotheque.Domain.model.Loan;
import com.pkf.projet_bibliotheque.Infrastructure.Persistence.Entity.LoanEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LoanEntityMapper {

    @Mapping(target = "book", expression = "java(loan.getBookId() != null ? BookEntity.builder().id(loan.getBookId()).build() : null)")
    @Mapping(target = "member", expression = "java(loan.getMemberId() != null ? MemberEntity.builder().id(loan.getMemberId()).build() : null)")
    LoanEntity toLoanEntity(Loan loan);

    @Mapping(target = "bookId", source = "book.id")
    @Mapping(target = "memberId", source = "member.id")
    Loan toDomain(LoanEntity loanEntity);

}
