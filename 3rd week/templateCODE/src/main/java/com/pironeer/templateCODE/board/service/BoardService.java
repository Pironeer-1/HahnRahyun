package com.pironeer.templateCODE.board.service;

import com.pironeer.templateCODE.board.dto.request.BoardCreateRequest;
import com.pironeer.templateCODE.board.dto.request.BoardUpdateRequest;
import com.pironeer.templateCODE.board.dto.response.BoardResponse;
import com.pironeer.templateCODE.board.entity.Board;
import com.pironeer.templateCODE.board.repository.BoardMemoryRepository;
import com.pironeer.templateCODE.global.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMemoryRepository boardMemoryRepository;
    public void save(BoardCreateRequest request) {
        boardMemoryRepository.save(BoardMapper.from(request));
    }

    // 게시글 전체 조회하기
    public List<BoardResponse> findAll() {
        List<Board> boards = boardMemoryRepository.findAll();
        return boards.stream().map(BoardResponse::of).toList();
    }

    // 게시글 id로 조회하기
    public BoardResponse findById(Long id) {
        Board board = boardMemoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TOPIC NOT FOUND"));
        return BoardResponse.of(board);
    }

    // 게시글 수정
    public BoardResponse update(BoardUpdateRequest request) {
        Board board = boardMemoryRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("TOPIC NOT FOUND"));
        boardMemoryRepository.update(board.update(request));
        return BoardResponse.of(board);
    }

    // 게시글 삭제
    public void deleteById(Long id) {
        boardMemoryRepository.deleteById(id);
    }
}
