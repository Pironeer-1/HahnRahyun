package com.pironeer.SpringBoard.controller;

import com.pironeer.SpringBoard.dto.request.TopicCreateRequest;
import com.pironeer.SpringBoard.dto.request.TopicUpdateRequest;
import com.pironeer.SpringBoard.dto.response.TopicResponse;
import com.pironeer.SpringBoard.service.TopicSercvice;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor // final 필드에 대한 생성자를 자동으로 생성
@Tag(name = "게시물(Topic)")
@RequestMapping("/api/topic")
public class TopicController {
    // TopicService를 주입받아 사용함
    // 어노테이션에 의해 생성자 주입이 자동으로 이루어짐
    private final TopicSercvice topicSercvice;

    @PostMapping // HTTP POST 요청을 처리
    @Operation(summary = "게시물 작성")
    // 게시물을 생성하고 성공 시 200 ok 응답 반환하는 메서드
    public ResponseEntity<?> create(@Valid @RequestBody TopicCreateRequest request) {
        topicSercvice.save(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{topicId}") // 특정 ID의 게시물을 조회하는 GET 요청 처리
    @Operation(summary = "게시물 단건 조회")
    public ResponseEntity<TopicResponse> read(@PathVariable("topicId") Long id) {
        TopicResponse response = topicSercvice.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    @Operation(summary = "게시물 전체 조회")
    public ResponseEntity<List<TopicResponse>> readAll() {
        List<TopicResponse> responses = topicSercvice.findAll();
        return ResponseEntity.ok().body(responses);
    }

    @PutMapping
    @Operation(summary = "게시물 수정")
    public ResponseEntity<TopicResponse> update(@Valid @RequestBody TopicUpdateRequest request) {
        TopicResponse response = topicSercvice.update(request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{topicId}")
    @Operation(summary = "게시물 삭제")
    public ResponseEntity<?> remove(@PathVariable("topicId") Long id) {
        topicSercvice.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
