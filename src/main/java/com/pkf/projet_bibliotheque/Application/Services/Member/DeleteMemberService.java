package com.pkf.projet_bibliotheque.Application.Services.Member;

import com.pkf.projet_bibliotheque.Application.Ports.Input.Member.DeleteMemberUseCase;
import com.pkf.projet_bibliotheque.Application.Ports.Output.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteMemberService implements DeleteMemberUseCase {
    private final MemberRepository memberRepository;

    @Override
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
