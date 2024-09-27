package com.pironeer.templateCODE.board.service;

import com.pironeer.templateCODE.board.dto.request.BoardCreateRequest;
import com.pironeer.templateCODE.board.entity.Board;
import com.pironeer.templateCODE.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public void save(BoardCreateRequest request) {
        Board board = Board.builder()
                .title(request.title())
                .content(request.content())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        boardRepository.save(board);
    }
}
