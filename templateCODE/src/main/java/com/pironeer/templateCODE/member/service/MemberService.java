package com.pironeer.templateCODE.member.service;

import com.pironeer.templateCODE.global.dto.response.JwtTokenSet;
import com.pironeer.templateCODE.global.dto.response.result.SingleResult;
import com.pironeer.templateCODE.global.exception.ErrorCode;
import com.pironeer.templateCODE.global.mapper.MemberMapper;
import com.pironeer.templateCODE.global.service.AuthService;
import com.pironeer.templateCODE.global.service.ResponseService;
import com.pironeer.templateCODE.member.dto.request.MemberRequest;
import com.pironeer.templateCODE.member.entity.Member;
import com.pironeer.templateCODE.member.repository.MemberMemoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMemoryRepository memberMemoryRepository;
    private final AuthService authService;

    public SingleResult<JwtTokenSet> register(MemberRequest request){
        if(memberMemoryRepository.existByMemberId(request.memberId())) {
            throw new RuntimeException(ErrorCode.USER_ALREADY_EXIST.getMessage());
        }

        Member member = memberMemoryRepository.save(MemberMapper.from(request));
        JwtTokenSet token = authService.generateToken(member.getId());
        return ResponseService.getSingleResult(token);
    }

    public SingleResult<JwtTokenSet> login(MemberRequest request){
        Member member = memberMemoryRepository.findByMemberId(request.memberId())
                .orElseThrow(() -> new RuntimeException(ErrorCode.USER_NOT_EXIST.getMessage()));

        if(!member.getPassword().equals(request.password())){
            throw new RuntimeException(ErrorCode.USER_WRONG_PASSWORD.getMessage());
        }

        JwtTokenSet token = authService.generateToken(member.getId());
        return ResponseService.getSingleResult(token);
    }
}
