package com.pkf.projet_bibliotheque.Application.Services.Member;

import com.pkf.projet_bibliotheque.Application.Ports.Input.Member.ListMemberUseCase;
import com.pkf.projet_bibliotheque.Application.Ports.Output.MemberRepository;
import com.pkf.projet_bibliotheque.Domain.model.Member;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ListMemberService implements ListMemberUseCase {
    private final MemberRepository memberRepository;

    @Override
    public List<Member> findAllMembers() {
        return memberRepository.findAllMembers();
    }
}
