package com.pkf.projet_bibliotheque.Infrastructure.Adapter;

import com.pkf.projet_bibliotheque.Application.Ports.Output.MemberRepository;
import com.pkf.projet_bibliotheque.Domain.model.Member;
import com.pkf.projet_bibliotheque.Infrastructure.Persistence.Entity.MemberEntity;
import com.pkf.projet_bibliotheque.Infrastructure.Persistence.JPA.JpaMemberRepository;
import com.pkf.projet_bibliotheque.Infrastructure.Persistence.Mapper.MemberEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MemberRepositoryAdapter implements MemberRepository {
    private final JpaMemberRepository jpaMemberRepository;
    private final MemberEntityMapper memberEntityMapper;

    @Override
    public Member save(Member member) {
        MemberEntity memberEntity = memberEntityMapper.toEntity(member);
        MemberEntity memberSaved = jpaMemberRepository.save(memberEntity);
        return memberEntityMapper.toDomain(memberSaved);
    }

    @Override
    public Optional<Member> findById(Long id) {
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
    public Optional<Member> findByEmail(String email) {
        return jpaMemberRepository.findByEmail(email)
                .map(memberEntityMapper::toDomain);
    }

    @Override
    public List<Member> findByName(String name) {
        return jpaMemberRepository.findByName(name)
                .stream()
                .map(memberEntityMapper::toDomain)
                .collect(Collectors.toList());


    }

    @Override
    public List<Member> findByFirstName(String firstName) {
        return jpaMemberRepository.findByFirstName(firstName)
                .stream()
                .map(memberEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaMemberRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaMemberRepository.existsById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaMemberRepository.existsByEmail(email);
    }

    @Override
    public long count() {
        return jpaMemberRepository.count();
    }
}
