package com.pkf.projet_bibliotheque.Presentation.Mapper;

import com.pkf.projet_bibliotheque.Domain.model.Loan;
import com.pkf.projet_bibliotheque.Presentation.Dto.Request.LoanRequestDto;
import com.pkf.projet_bibliotheque.Presentation.Dto.Response.LoanResponseDto;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring",imports = UUID.class)
public interface LoanDtoMapper {
    LoanResponseDto toDto(Loan loan);
    Loan toDomain(LoanRequestDto loanRequestDto);
}
