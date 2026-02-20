package com.pkf.projet_bibliotheque.Application.Ports.Input.Member;

import com.pkf.projet_bibliotheque.Domain.model.Member;

import java.util.UUID;

public interface GetMemberUseCase {
    Member findByIdMember(Long id);
}
