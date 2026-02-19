package com.pkf.projet_bibliotheque.Application.Ports.Input.Member;

import com.pkf.projet_bibliotheque.Domain.model.Member;

public interface UpdateMemberUseCase {
    Member updateMember(Long id, Member member);
}
