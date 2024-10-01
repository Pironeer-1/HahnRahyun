package com.pironeer.templateCODE.board.repository;

import com.pironeer.templateCODE.board.entity.Board;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BoardMemoryRepository implements BoardRepository{
    private final AtomicLong boardIdxGenerator = new AtomicLong(0);
    private final HashMap<Long, Board> boardMap = new HashMap<>();

    @Override
    public void save(Board board) {
        Long boardId = boardIdxGenerator.incrementAndGet();
        board.setId(boardId);
        boardMap.put(boardId, board);
    }

    // 전체 게시물 조회
    @Override
    public List<Board> findAll() {
        return boardMap.values().stream().toList();
    }

    // 게시물 id로 조회
    @Override
    public Optional<Board> findById(Long id) {
        Assert.notNull(id, "ID must not be null!");
        return Optional.ofNullable(boardMap.get(id));
    }

    // 게시글 수정
    @Override
    public void update(Board board) {
        boardMap.replace(board.getId(), board);
    }

    // 게시글 삭제
    @Override
    public void deleteById(Long id) {
        Assert.notNull(id, "ID must not be null!");
        boardMap.remove(id);
    }
}
