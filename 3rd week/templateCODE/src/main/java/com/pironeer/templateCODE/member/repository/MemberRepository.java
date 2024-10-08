package com.pironeer.templateCODE.member.repository;

import com.pironeer.templateCODE.member.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    List<Member> findAll();

    Optional<Member> findById(Long id);

    Optional<Member> findByMemberId(String memberId);

    boolean existByMemberId(String memberId);
}
