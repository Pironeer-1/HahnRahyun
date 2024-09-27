package com.pironeer.templateCODE.board.controller;

import com.pironeer.templateCODE.board.dto.request.BoardCreateRequest;
import com.pironeer.templateCODE.board.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
