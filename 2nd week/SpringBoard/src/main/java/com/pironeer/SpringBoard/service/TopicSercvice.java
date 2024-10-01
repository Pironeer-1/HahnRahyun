package com.pironeer.SpringBoard.service;

import com.pironeer.SpringBoard.dto.request.TopicCreateRequest;
import com.pironeer.SpringBoard.dto.request.TopicUpdateRequest;
import com.pironeer.SpringBoard.dto.response.TopicResponse;
import com.pironeer.SpringBoard.mapper.TopicMapper;
import com.pironeer.SpringBoard.repository.TopicRepository;
import com.pironeer.SpringBoard.repository.domain.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicSercvice { // Topic 객체에 대한 CRUD 수행하는 서비스 계층의 클래스
    private final TopicRepository topicRepository; // 어노테이션에 의해 자동으로 생성자 주입

    public void save(TopicCreateRequest request) { // 새로운 Topic을 저장하는 메서드
        // TopicMapper.from(request)를 통해 DTO를 객체로 변환한 후 저장
        topicRepository.save(TopicMapper.from(request));
    }

    public TopicResponse findById(Long id) { // id로 Topic 찾는 메서드
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TOPIC NOT FOUND"));
        return TopicResponse.of(topic); // 찾으면 TopicResponse로 변환하여 리턴
    }

    public List<TopicResponse> findAll() { // 모든 Topic을 조회하고 TopicResponse 리스트로 변환하는 메서드
        List<Topic> topics = topicRepository.findAll();
        return topics.stream().map(TopicResponse::of).toList();
    }

    public TopicResponse update(TopicUpdateRequest request) { // Topic 업데이트 메서드
        Topic topic = topicRepository.findById(request.id()) // TopicUpdateRequest에서 id 가져오기
                .orElseThrow(() -> new RuntimeException("TOPIC NOT FOUND")); // 못 찾으면 런타임에러
        topicRepository.save(topic.update(request)); // TopicUpdateRequest의 정보로
        // Topic을 업데이트하고, topicRepository에 저장
        return TopicResponse.of(topic); // 결과를 TopicResponse DTO로 변환하여 리턴
    }

    public void deleteById(Long id) { // id를 인자로 받아 해당 topic을 삭제하는 메서드
        topicRepository.deleteById(id);
    }
}