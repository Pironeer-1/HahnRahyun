package com.pironeer.templateCODE.member.controller;


import com.pironeer.templateCODE.global.dto.response.JwtTokenSet;
import com.pironeer.templateCODE.global.dto.response.SuccessResponse;
import com.pironeer.templateCODE.global.dto.response.result.SingleResult;
import com.pironeer.templateCODE.member.dto.request.MemberRequest;
import com.pironeer.templateCODE.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "회원(Member)")
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    @Operation(summary = "회원가입")
    public SuccessResponse<SingleResult<JwtTokenSet>> register(@Valid @RequestBody MemberRequest request) {
        SingleResult<JwtTokenSet> result = memberService.register(request);
        return SuccessResponse.ok(result);
    }

    @PostMapping("/login")
    @Operation(summary = "로그인")
    public SuccessResponse<SingleResult<JwtTokenSet>> login(@Valid @RequestBody MemberRequest request) {
        SingleResult<JwtTokenSet> result = memberService.login(request);
        return SuccessResponse.ok(result);
    }
}
