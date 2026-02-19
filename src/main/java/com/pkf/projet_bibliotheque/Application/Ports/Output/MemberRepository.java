package com.pkf.projet_bibliotheque.Application.Ports.Output;

import com.pkf.projet_bibliotheque.Domain.model.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findById(Long id);

    List<Member> findAll();

    Optional<Member> findByEmail(String email);

    List<Member> findByName(String name);

    List<Member> findByFirstName(String firstName);

    void deleteById(Long id);

    boolean existsById(Long id);

    boolean existsByEmail(String email);

    long count();
}
