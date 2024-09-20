package com.pironeer.SpringBoard.service;

import com.pironeer.SpringBoard.dto.request.CommentCreateRequest;
import com.pironeer.SpringBoard.repository.domain.Comment;
import com.pironeer.SpringBoard.dto.response.CommentResponse;
import com.pironeer.SpringBoard.mapper.CommentMapper;
import com.pironeer.SpringBoard.repository.CommentRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public void saveComment(CommentCreateRequest request) {
        commentRepository.save(CommentMapper.from(request));
    }

    // 게시물 id로 모든 댓글 조회
    public List<CommentResponse> findByTopicId(Long topicId) {
        List<Comment> comments = commentRepository.findByTopicId(topicId);
        return comments.stream().map(CommentResponse::of).toList();
    }

    // 부모 댓글 id로 모든 대댓글 조회
    public List<CommentResponse> findByParentId(Long parentId) {
        List<Comment> re_cmt = commentRepository.findByParentId(parentId);
        return re_cmt.stream().map(CommentResponse::of).toList();
    }
}