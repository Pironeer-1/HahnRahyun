package com.pironeer.templateCODE.board.repository;

import com.pironeer.templateCODE.board.entity.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    void save(Board board);

    List<Board> findAll();

    Optional<Board> findById(Long id);

    void update(Board board);

    void deleteById(Long id);
}
