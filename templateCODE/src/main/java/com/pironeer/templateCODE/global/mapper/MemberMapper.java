package com.pironeer.templateCODE.global.mapper;

import com.pironeer.templateCODE.member.dto.request.MemberRequest;
import com.pironeer.templateCODE.member.entity.Member;

public class MemberMapper {
    public static Member from (MemberRequest request) {
        return Member.builder()
                .memberId(request.memberId())
                .password(request.password())
                .name(request.name())
                .build();
    }
}
