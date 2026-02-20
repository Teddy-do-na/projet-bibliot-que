package com.pkf.projet_bibliotheque.Infrastructure.Persistence.Mapper;

import com.pkf.projet_bibliotheque.Domain.model.Member;
import com.pkf.projet_bibliotheque.Infrastructure.Persistence.Entity.MemberEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberEntityMapper {
    MemberEntity toEntity(Member member);
    Member toDomain(MemberEntity memberEntity);
}
