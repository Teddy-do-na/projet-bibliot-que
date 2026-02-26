package com.pkf.projet_bibliotheque.Presentation.Mapper;

import com.pkf.projet_bibliotheque.Domain.model.Loan;
import com.pkf.projet_bibliotheque.Presentation.Dto.Request.LoanRequestDto;
import com.pkf.projet_bibliotheque.Presentation.Dto.Response.LoanResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface LoanDtoMapper {

    LoanResponseDto toDto(Loan loan);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dueDate", ignore = true)
    @Mapping(target = "returnDate", ignore = true)
    @Mapping(target = "penalty", ignore = true)
    @Mapping(target = "renewalCount", ignore = true)
    Loan toDomain(LoanRequestDto loanRequestDto);
}
