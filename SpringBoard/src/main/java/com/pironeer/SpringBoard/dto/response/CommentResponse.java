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
        Long cmtId,
        @Schema(description = "소속 게시글 id", example = "1")
        Long topicId, // 소속 게시글 id
        @Schema(description = "부모 댓글 id", example = "2")
        Long parentId, // 부모 댓글 id
        @Schema(description = "댓글 내용", example = "댓글 내용입니다")
        String cmtCnt, // 댓글 내용
        @Schema(description = "댓글 작성 시간", example = "2024-10-10 10:10:00")
        LocalDateTime cmtCreatedAt,
        @Schema(description = "댓글 수정 시간", example = "2024-10-10 10:10:00")
        LocalDateTime cmtUpdatedAt) {
    public static CommentResponse of(Comment comment) {
        // (domain) Comment Entity -> CommentResponse 객체로 변환
        return CommentResponse.builder()
                .cmtId(comment.getCmtId())
                .topicId(comment.getTopicId())
                .parentId(comment.getParentId())
                .cmtCnt(comment.getCmtCnt())
                .cmtCreatedAt(comment.getCmtCreatedAt())
                .cmtUpdatedAt(comment.getCmtUpdatedAt())
                .build();
    }
}
