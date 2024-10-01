package com.pironeer.SpringBoard.dto.response;

import com.pironeer.SpringBoard.repository.domain.Topic;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TopicResponse( //
        @Schema( // 게시물 ID를 나타내는 필드
                description = "게시물 ID",
                example = "1",
                type = "long",
                requiredMode = Schema.RequiredMode.REQUIRED)
        Long id, // id는 Long 타입
        @Schema( // 게시물 제목을 나타내는 필드
                description = "게시물 제목",
                example = "제목입니다",
                type = "string",
                requiredMode = Schema.RequiredMode.REQUIRED)
        String title, // title은 String 타입
        @Schema( // 게시물 내용을 나타내는 필드
                description = "게시물 내용",
                example = "내용입니다",
                type = "string",
                requiredMode = Schema.RequiredMode.REQUIRED)
        String content, // content는 String 타입
        @Schema( // 게시물 생성 시간을 나타내는 필드
                description = "게시물 생성 시간",
                example = "2024-10-10 10:10:00",
                type = "string",
                requiredMode = Schema.RequiredMode.REQUIRED)
        LocalDateTime createdAt, // createdAt은 LocalDateTime 타입
        @Schema( // 게시물 수정 시간을 나타내는 필드
                description = "게시물 수정 시간",
                example = "2024-10-13 10:10:00",
                type = "string",
                requiredMode = Schema.RequiredMode.REQUIRED)
        LocalDateTime updatedAt) {
    // topic 객체를 받아 TopicResponse 객체로 변환하는 정적 메서드
    public static TopicResponse of(Topic topic) {
        return TopicResponse.builder()
                .id(topic.getId())
                .title(topic.getTitle())
                .content(topic.getContent())
                .createdAt(topic.getCreatedAt())
                .updatedAt(topic.getUpdatedAt())
                .build();
    }
}