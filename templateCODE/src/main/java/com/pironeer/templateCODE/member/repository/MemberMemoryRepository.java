package com.pironeer.templateCODE.member.repository;

import com.pironeer.templateCODE.member.entity.Member;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemberMemoryRepository implements MemberRepository {
    private final AtomicLong memberIdxGenerator = new AtomicLong(0);
    private final Map<Long, Member> memberMap = new HashMap<>();

    @Override
    public Member save (Member member) {
        Long id = memberIdxGenerator.incrementAndGet();
        member.setId(id);
        memberMap.put(id, member);
        return member;
    }

    @Override
    public List<Member> findAll() {
        return memberMap.values().stream().toList();
    }

    @Override
    public Optional<Member> findById(Long id) {
        Assert.notNull(id, "ID must not be null");
        return Optional.ofNullable(memberMap.get(id));
    }

    @Override
    public Optional<Member> findByMemberId(String memberId) {
        return memberMap.values().stream()
                .filter(data -> data.getMemberId().equals(memberId))
                .findAny();
    }

    @Override
    public boolean existByMemberId(String memberId) {
        return memberMap.values().stream()
                .anyMatch(data -> data.getMemberId().equals(memberId));
    }
}
