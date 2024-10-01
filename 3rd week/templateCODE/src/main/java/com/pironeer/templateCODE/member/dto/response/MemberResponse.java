package com.pironeer.templateCODE.member.dto.response;

import com.pironeer.templateCODE.member.entity.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record MemberResponse(

        @NotBlank
        @Schema(description = "회원 id", example = "1")
        String memberId,

        @NotBlank
        @Schema(description = "비밀번호", example = "1")
        String password,

        @NotBlank
        @Schema(description = "회원 이름", example = "한라현")
        String name) {

    public static MemberResponse of (Member member) {
        return MemberResponse.builder()
                .memberId(member.getMemberId())
                .password(member.getPassword())
                .name(member.getName())
                .build();
    }
}
