package com.pkf.projet_bibliotheque.Presentation.Mapper;

import com.pkf.projet_bibliotheque.Domain.model.Member;
import com.pkf.projet_bibliotheque.Presentation.Dto.Request.MemberRequestDto;
import com.pkf.projet_bibliotheque.Presentation.Dto.Response.MemberResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberDtoMapper {
    MemberResponseDto toDto(Member member);
    Member toDomain(MemberRequestDto memberRequestDto);
}
