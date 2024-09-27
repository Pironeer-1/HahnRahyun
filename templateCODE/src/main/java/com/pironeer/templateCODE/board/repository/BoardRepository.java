package com.pironeer.templateCODE.board.repository;

import com.pironeer.templateCODE.board.entity.Board;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BoardRepository {
    private final AtomicLong boardIdxGenerator = new AtomicLong(0);
    private final HashMap<Long, Board> boardMap = new HashMap<>();

    // 게시글 저장
    public void save(Board board) {
        Long boardId = boardIdxGenerator.incrementAndGet();
        board.setId(boardId);
        boardMap.put(boardId, board);
    }
}
