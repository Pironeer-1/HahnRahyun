package com.pironeer.SpringBoard.repository;

import com.pironeer.SpringBoard.repository.domain.Topic;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TopicRepository {
    // 게시물 ID 생성. AtomicLong을 통해 멀티스레드 환경에서 안전하게 숫자 증가 가능
    private final AtomicLong topicIdxGenerator = new AtomicLong(0);
    // 게시물을 저장할 HashMap 생성. 게시물의 ID = key, Topic 객체 = 값
    private final Map<Long, Topic> topicMap = new HashMap<>();

    public void save(Topic topic) { // Topic 객체를 저장하는 메서드
        if(topic.getId() == null) { // 객체의 id가 없으면
            Long id = topicIdxGenerator.incrementAndGet(); // 새로운 ID 생성
            topic.setId(id); // 생성된 id를 객체 id에 set
            topicMap.put(id, topic); // 객체를 해시맵에 저장
        } else { // 객체의 id가 있으면
            topicMap.replace(topic.getId(), topic);
            // 해당 객체의 id와 객체를 인자로 받아 해시맵에 재저장 = 업데이트
        }
    }

    public Optional<Topic> findById(Long id) { // ID로 게시물을 찾는 메서드
        Assert.notNull(id, "ID MUST NOT BE NULL");
        return Optional.ofNullable(topicMap.get(id));
    }

    public List<Topic> findAll() { // 모든 게시물을 리스트로 반환하는 메서드
        return topicMap.values().stream().toList();
    }

    public void deleteById(Long id) {
        Assert.notNull(id, "ID MUST NOT BE NULL");
        topicMap.remove(id); // 해당 id 게시문을 해시맵에서 삭제
    }
}