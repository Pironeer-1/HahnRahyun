package com.pironeer.SpringBoard.dto.response;

import com.pironeer.SpringBoard.repository.domain.Comment;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
// 서버 -> 클라이언트
// Comment 객체 -> CommentResponse
public record CommentResponse(
        Long cmt_id, // 댓글 id
        Long topic_id, // 소속 게시글 id
        Long parent_id, // 부모 댓글 id
        String cmt_cnt, // 댓글 내용
        LocalDateTime cmt_createdAt) {
    public static CommentResponse of(Comment comment) {
        // (domain) Comment Entity -> CommentResponse 객체로 변환
        return CommentResponse.builder()
                .cmt_id(comment.getCmt_id())
                .topic_id(comment.getTopic_id())
                .parent_id(comment.getParent_id())
                .cmt_cnt(comment.getCmt_cnt())
                .cmt_createdAt(comment.getCmt_createdAt())
                .build();
    }
}
