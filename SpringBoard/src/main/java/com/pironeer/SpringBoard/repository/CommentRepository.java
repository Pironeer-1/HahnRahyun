package com.pironeer.SpringBoard.repository;

import com.pironeer.SpringBoard.repository.domain.Comment;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class CommentRepository {
    private final AtomicLong commentIdxGenerator = new AtomicLong(0);
    private final Map<Long, Comment> commentMap = new HashMap<>();

    public void save(Comment comment) {
        if (comment.getCmt_id() == null) { // 새 댓글인 경우
            Long id = commentIdxGenerator.incrementAndGet(); // id를 생성
            comment.setCmt_id(id); // comment 객체의 cmt_id에 생성된 id 넣기
            commentMap.put(id, comment); // 맵에 생성된 id와 댓글 객체를 넣기
        } else { // 이미 해당 id값이 있는 경우
            commentMap.replace(comment.getCmt_id(), comment); // 새로운 댓글로 교체
        }
    }

    // 특정 게시글에 대한 모든 댓글 조회
    public List<Comment> findByTopicId(Long topicId) { // 댓글을 조회하고 싶은 게시글 id를 인자로 전달
        return commentMap.values().stream() // 저장된 모든 댓글을 스트림으로 변환
                .filter(comment -> comment.getTopic_id().equals(topicId)) // 전달받은 인자 값과 댓글의 값이 같은지 비교
                .collect(Collectors.toList()); // 필터링된 댓글을 수집 후 반환
    }

    // 특정 부모 댓글에 대한 모든 대댓글 조회
    public List<Comment> findByParentId(Long parentId) { // 모든 대댓글을 조회하고 싶은 부모 댓글 id를 인자로 전달
        return commentMap.values().stream() // 저장된 모든 댓글을 스트림으로 변환
                .filter(comment -> parentId.equals(comment.getParent_id())) // 해당 댓글들 필터링
                .collect(Collectors.toList());
    }
}
