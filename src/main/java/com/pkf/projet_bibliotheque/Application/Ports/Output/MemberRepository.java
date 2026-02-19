package com.pkf.projet_bibliotheque.Application.Ports.Output;

import com.pkf.projet_bibliotheque.Domain.model.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Optional<Member> findById(Long id);
    Member save(Member member);
    List<Member> findAllMembers();
    void deleteById(Long memberId);
    boolean existsById(Long memberId);
    boolean existsByEmail(String email);
}
