package com.pkf.projet_bibliotheque.Application.Ports.Input.Member;

import com.pkf.projet_bibliotheque.Domain.model.Loan;
import com.pkf.projet_bibliotheque.Domain.model.Member;

import java.util.UUID;

public interface UpdateMemberUseCase {
    Member updateMember(Long id, Member member);
}
