package com.pkf.projet_bibliotheque.Application.Services.Member;

import com.pkf.projet_bibliotheque.Application.Ports.Input.Member.UpdateMemberUseCase;
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
public class UpdateMemberService implements UpdateMemberUseCase {
    private final MemberRepository memberRepository;

    @Override
    public Member updateMember(Long id, Member member) {
        Member updatedMember = memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("Membre non trouvé avec cet id " + id));
        if (member.getName() != null) updatedMember.setName(member.getName());
        if (member.getFirstName() != null) updatedMember.setFirstName(member.getFirstName());
        if (member.getEmail() != null) updatedMember.setEmail(member.getEmail());
        if (member.getAdhesionDate() != null) updatedMember.setAdhesionDate(member.getAdhesionDate());
        return memberRepository.save(updatedMember);
    }
}
