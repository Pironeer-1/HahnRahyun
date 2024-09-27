package com.pironeer.templateCODE.board.controller;

import com.pironeer.templateCODE.board.dto.request.BoardCreateRequest;
import com.pironeer.templateCODE.board.dto.request.BoardUpdateRequest;
import com.pironeer.templateCODE.board.dto.response.BoardResponse;
import com.pironeer.templateCODE.board.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "게시글 (Board)")
@RequestMapping("/api/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping()
    @Operation(summary = "게시글 생성")
    public ResponseEntity<?> create(@Valid @RequestBody BoardCreateRequest request) {
        boardService.save(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    @Operation(summary = "전체 게시글 조회")
    public ResponseEntity<?> readAll() {
        List<BoardResponse> responses = boardService.findAll();
        return ResponseEntity.ok().body(responses);
    }

    @GetMapping("/{boardId}")
    @Operation(summary = "id로 게시글 조회")
    public ResponseEntity<?> read(@PathVariable("boardId") Long id) {
        BoardResponse response = boardService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping
    @Operation(summary = "게시글 수정")
    public ResponseEntity<?> update(@Valid @RequestBody BoardUpdateRequest request) {
        BoardResponse response = boardService.update(request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{boardId}")
    @Operation(summary = "게시글 삭제")
    public ResponseEntity<?> delete(@PathVariable("boardId") Long id) {
        boardService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
