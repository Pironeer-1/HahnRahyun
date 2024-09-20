package com.pironeer.SpringBoard.mapper;

import com.pironeer.SpringBoard.repository.domain.Comment;
import com.pironeer.SpringBoard.dto.request.CommentCreateRequest;

import java.time.LocalDateTime;


public class CommentMapper {
    // CommentCreateRequest 객체를 매개변수로 받아 Comment 객체로 변환
    public static Comment from(CommentCreateRequest request) {
        LocalDateTime now = LocalDateTime.now();
        return Comment.builder()
                .topic_id(request.topic_id())
                .parent_id(request.parent_id())
                .cmt_cnt(request.cmt_cnt())
                .cmt_createdAt(now)
                .build();
    }
}
