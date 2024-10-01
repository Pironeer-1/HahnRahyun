package com.pironeer.SpringBoard.controller;

import com.pironeer.SpringBoard.dto.request.CommentCreateRequest;
import com.pironeer.SpringBoard.dto.request.CommentUpdateRequest;
import com.pironeer.SpringBoard.dto.response.CommentResponse;
import com.pironeer.SpringBoard.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "댓글(Comment)")
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentService commentService;

    // 댓글 저장
    @PostMapping
    @Operation(summary = "댓글 작성")
    public ResponseEntity<?> create(@Valid @RequestBody CommentCreateRequest request) {
        commentService.saveComment(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Operation(summary = "댓글 수정")
    public ResponseEntity<?> updateComment(@Valid @RequestBody CommentUpdateRequest request) {
        try {
            CommentResponse response = commentService.updateComment(request);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{cmtId}")
    @Operation(summary = "댓글 삭제")
    public ResponseEntity<?> deleteCmt(@PathVariable("cmtId") Long cmt_id) {
        try {
            commentService.deleteCmt(cmt_id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    @Operation(summary = "모든 댓글 조회")
    public ResponseEntity<List<CommentResponse>> getAllComments() {
        List<CommentResponse> responses = commentService.findAllComments();
        return ResponseEntity.ok(responses);
    }

    // 특정 게시물의 모든 댓글 조회
    @GetMapping("/topic/{topicId}")
    @Operation(summary = "특정 게시물의 모든 댓글 조회")
    public ResponseEntity<List<CommentResponse>> getCommentsByTopicId(@PathVariable("topicId") Long topicId) {
        List<CommentResponse> responses = commentService.findByTopicId(topicId);
        return ResponseEntity.ok().body(responses);
    }

    // 부모 댓글 id로 모든 대댓글 조회
    @GetMapping("/{parentId}")
    @Operation(summary = "부모 댓글의 자식 댓글 조회")
    public ResponseEntity<List<CommentResponse>> getRecmtByParentId(@PathVariable("parentId") Long parentId) {
        List<CommentResponse> responses = commentService.findByParentId(parentId);
        return ResponseEntity.ok().body(responses);
    }
}