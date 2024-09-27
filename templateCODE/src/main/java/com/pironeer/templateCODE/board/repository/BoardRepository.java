package com.pironeer.templateCODE.board.repository;

import com.pironeer.templateCODE.board.entity.Board;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
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

    // 게시글 전체 조회
    public List<Board> findAll() {
        return boardMap.values().stream().toList();
    }

    // 게시글 id로 조회하기
    public Optional<Board> findById(Long id) {
        Assert.notNull(id, "ID는 null일 수 없습니다");
        return Optional.ofNullable(boardMap.get(id));
    }

    // 게시글 수정
    public void update(Board board) {
        boardMap.replace(board.getId(), board);
    }
}
