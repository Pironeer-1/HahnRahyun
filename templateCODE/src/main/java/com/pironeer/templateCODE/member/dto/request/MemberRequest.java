package com.pironeer.templateCODE.member.dto.request;

import jakarta.validation.constraints.NotBlank;

public record MemberRequest(
        @NotBlank
        String memberId,

        @NotBlank
        String password,

        @NotBlank
        String name) {
}
