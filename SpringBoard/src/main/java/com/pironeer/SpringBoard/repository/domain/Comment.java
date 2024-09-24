package com.pironeer.SpringBoard.repository.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private Long cmtId; // 댓글 id (pk)
    private Long topicId; // 게시물 id (외래키)
    private Long parentId; // 부모 댓글 id, 값이 있으면 대댓글
    private String cmtCnt; // 댓글 내용
    private LocalDateTime cmtCreatedAt; // 댓글 생성 시간
    private LocalDateTime cmtUpdatedAt;

    @Builder
    public Comment(
            Long cmtId,
            Long topicId,
            Long parentId,
            String cmtCnt,
            LocalDateTime cmtCreatedAt,
            LocalDateTime cmtUpdatedAt) {
        this.cmtId = cmtId;
        this.topicId = topicId;
        this.parentId = parentId;
        this.cmtCnt = cmtCnt;
        this.cmtCreatedAt = cmtCreatedAt;
        this.cmtUpdatedAt = cmtUpdatedAt;
    }

    public void update(String cmtCnt) {
        this.cmtCnt = cmtCnt;
        this.cmtUpdatedAt = LocalDateTime.now();
    }
}
