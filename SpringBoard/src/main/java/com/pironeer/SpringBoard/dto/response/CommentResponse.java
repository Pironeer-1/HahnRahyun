package com.pironeer.SpringBoard.dto.response;

import com.pironeer.SpringBoard.repository.domain.Comment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
// 서버 -> 클라이언트
// Comment 객체 -> CommentResponse
public record CommentResponse(
        @Schema(description = "댓글 id", example = "1")
        Long cmt_id,
        @Schema(description = "소속 게시글 id", example = "1")
        Long topic_id, // 소속 게시글 id
        @Schema(description = "부모 댓글 id", example = "2")
        Long parent_id, // 부모 댓글 id
        @Schema(description = "댓글 내용", example = "댓글 내용입니다")
        String cmt_cnt, // 댓글 내용
        @Schema(description = "댓글 작성 시간", example = "2024-10-10 10:10:00")
        LocalDateTime cmt_createdAt,
        @Schema(description = "댓글 수정 시간", example = "2024-10-10 10:10:00")
        LocalDateTime cmt_updatedAt) {
    public static CommentResponse of(Comment comment) {
        // (domain) Comment Entity -> CommentResponse 객체로 변환
        return CommentResponse.builder()
                .cmt_id(comment.getCmt_id())
                .topic_id(comment.getTopic_id())
                .parent_id(comment.getParent_id())
                .cmt_cnt(comment.getCmt_cnt())
                .cmt_createdAt(comment.getCmt_createdAt())
                .cmt_updatedAt(comment.getCmt_updatedAt())
                .build();
    }
}
