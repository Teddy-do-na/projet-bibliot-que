package com.pkf.projet_bibliotheque.Application.Services.Member;

import com.pkf.projet_bibliotheque.Application.Ports.Input.Member.GetMemberUseCase;
import com.pkf.projet_bibliotheque.Application.Ports.Output.MemberRepository;
import com.pkf.projet_bibliotheque.Domain.exception.memberException.MemberNotFoundException;
import com.pkf.projet_bibliotheque.Domain.model.Member;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class GetMemberService implements GetMemberUseCase {
    private final MemberRepository memberRepository;


    @Override
    public Member findByIdMember(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("Membre non trouvé avec cet id " + id));
    }
}
