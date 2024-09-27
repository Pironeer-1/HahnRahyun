package com.pironeer.templateCODE.board.service;

import com.pironeer.templateCODE.board.dto.request.BoardCreateRequest;
import com.pironeer.templateCODE.board.dto.response.BoardResponse;
import com.pironeer.templateCODE.board.entity.Board;
import com.pironeer.templateCODE.board.repository.BoardRepository;
import com.pironeer.templateCODE.global.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public void save(BoardCreateRequest request) {
        boardRepository.save(BoardMapper.from(request));
    }

    // 게시글 전체 조회하기
    public List<BoardResponse> findAll() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream().map(BoardResponse::of).toList();
    }

    // 게시글 id로 조회하기
    public BoardResponse findById(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다"));
        return BoardResponse.of(board);
    }
}
