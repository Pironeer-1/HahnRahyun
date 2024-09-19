package com.pironeer.SpringBoard.mapper;

import com.pironeer.SpringBoard.repository.domain.Topic;
import com.pironeer.SpringBoard.dto.request.TopicCreateRequest;

import java.time.LocalDateTime;

public class TopicMapper { // DTO와 도메인 객체 간의 변환을 담당

    // from이라는 정적 메소드 선언
    // TopicCreateRequest 객체를 매개변수로 받아 Topic 객체로 변환
    public static Topic from(TopicCreateRequest request) {
        LocalDateTime now = LocalDateTime.now();
        return Topic.builder() // Topic 클래스의 빌더 패턴을 사용하여 새로운 Topic 객체 생성
                .title(request.title())
                .content(request.content())
                .createdAt(now)
                .updatedAt(now)
                .build();
    }
}
