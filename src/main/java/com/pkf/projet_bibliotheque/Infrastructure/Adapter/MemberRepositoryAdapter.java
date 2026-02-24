package com.pkf.projet_bibliotheque.Infrastructure.Adapter;

import com.pkf.projet_bibliotheque.Application.Ports.Output.MemberRepository;
import com.pkf.projet_bibliotheque.Domain.exception.memberException.MemberNotFoundException;
import com.pkf.projet_bibliotheque.Domain.model.Member;
import com.pkf.projet_bibliotheque.Infrastructure.Persistence.Entity.MemberEntity;
import com.pkf.projet_bibliotheque.Infrastructure.Persistence.JPA.JpaMemberRepository;
import com.pkf.projet_bibliotheque.Infrastructure.Persistence.Mapper.MemberEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MemberRepositoryAdapter implements MemberRepository {
    private final JpaMemberRepository jpaMemberRepository;
    private final MemberEntityMapper memberEntityMapper;

    @Override
    public Member save(Member member) {
        if (jpaMemberRepository.existsByEmail(member.getEmail())){
            throw new RuntimeException("Un membre existe deja avec cet email");
        }
        MemberEntity memberEntity = memberEntityMapper.toEntity(member);
        MemberEntity memberSaved = jpaMemberRepository.save(memberEntity);
        return memberEntityMapper.toDomain(memberSaved);
    }

    @Override
    public Optional<Member> findById(Long id) {
        if (!jpaMemberRepository.existsById(id)){
            throw new MemberNotFoundException("Member not found");
        }
        return jpaMemberRepository.findById(id)
                .map(memberEntityMapper::toDomain);
    }

    @Override
    public List<Member> findAll() {
        return jpaMemberRepository.findAll()
                .stream()
                .map(memberEntityMapper::toDomain)
                .collect(Collectors.toList());
    }


    @Override
    public void deleteById(Long id) {
        if (!jpaMemberRepository.existsById(id)){
            throw new MemberNotFoundException("Member not found");
        }
        jpaMemberRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long memberId) {
        return jpaMemberRepository.existsById(memberId);
    }

}
