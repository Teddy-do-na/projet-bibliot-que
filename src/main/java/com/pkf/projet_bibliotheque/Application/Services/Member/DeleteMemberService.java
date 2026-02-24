package com.pkf.projet_bibliotheque.Application.Services.Member;

import com.pkf.projet_bibliotheque.Application.Ports.Input.Member.DeleteMemberUseCase;
import com.pkf.projet_bibliotheque.Application.Ports.Output.MemberRepository;
import com.pkf.projet_bibliotheque.Domain.exception.memberException.MemberNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteMemberService implements DeleteMemberUseCase {
    private final MemberRepository memberRepository;

    @Override
    public void deleteMember(Long memberId) {
        if(!memberRepository.existsById(memberId)){
            throw new MemberNotFoundException("Membre non trouvé avec cet id " + memberId);
        }
        memberRepository.deleteById(memberId);
    }
}
