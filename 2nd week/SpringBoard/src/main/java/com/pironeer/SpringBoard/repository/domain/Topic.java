package com.pironeer.SpringBoard.repository.domain;

import com.pironeer.SpringBoard.dto.request.TopicUpdateRequest;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Topic {
    private Long id; // 게시물의 ID
    private String title; // 게시물의 제목
    private String content; // 게시물의 내용
    private LocalDateTime createdAt; // 생성 시간
    private LocalDateTime updatedAt; // 수정 시간

    @Builder
    public Topic( // 객체 생성
            Long id,
            String title,
            String content,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // 게시물 업데이트 메서드
    // TopicUpdateRequest 객체를 받아 제목, 내용, 수정 시간 갱신된 Topic 객체 리턴
    // 객체 지향 - 캡슐화 원칙
    public Topic update(TopicUpdateRequest request) {
        this.title = request.title();
        this.content = request.content();
        this.updatedAt = LocalDateTime.now();
        return this;
    }
}