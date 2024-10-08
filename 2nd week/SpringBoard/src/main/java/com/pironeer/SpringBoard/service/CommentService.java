package com.pironeer.SpringBoard.service;

import com.pironeer.SpringBoard.dto.request.CommentCreateRequest;
import com.pironeer.SpringBoard.dto.request.CommentUpdateRequest;
import com.pironeer.SpringBoard.repository.domain.Comment;
import com.pironeer.SpringBoard.dto.response.CommentResponse;
import com.pironeer.SpringBoard.mapper.CommentMapper;
import com.pironeer.SpringBoard.repository.CommentRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    // 댓글 작성
    public void saveComment(CommentCreateRequest request) {
        commentRepository.save(CommentMapper.from(request));
    }

    // 댓글 수정
    public CommentResponse updateComment(CommentUpdateRequest request) {
        Comment comment = commentRepository.findById(request.cmtId())
                .orElseThrow(() -> new RuntimeException("댓글을 찾을 수 없습니다"));

        comment.update(request.cmtCnt());
        commentRepository.save(comment);

        return CommentResponse.of(comment);
    }

    // 전체 댓글 조회
    public List<CommentResponse> findAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(CommentResponse::of)
                .collect(Collectors.toList());
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

    public void deleteCmt(Long cmtId) {
        commentRepository.deleteCmtById(cmtId);
    }
}