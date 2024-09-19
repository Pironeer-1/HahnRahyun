package com.pironeer.SpringBoard.repository.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private Long cmt_id; // 댓글 id (pk)
    private Long topic_id; // 게시물 id (외래키)
    private Long parent_id; // 부모 댓글 id, 값이 있으면 대댓글
    private String cmt_cnt; // 댓글 내용
    private LocalDateTime cmt_createdAt; // 댓글 생성 시간

    @Builder
    public Comment(
            Long cmt_id,
            Long topic_id,
            Long parent_id,
            String cmt_cnt,
            LocalDateTime cmt_createdAt) {
        this.cmt_id = cmt_id;
        this.topic_id = topic_id;
        this.parent_id = parent_id;
        this.cmt_cnt = cmt_cnt;
        this.cmt_createdAt = cmt_createdAt;
    }
}
