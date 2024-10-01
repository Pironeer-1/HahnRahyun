package com.pironeer.templateCODE.board.dto.response;

import com.pironeer.templateCODE.board.entity.Board;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BoardResponse(
        @NotNull
        @Schema(description = "게시글 id", example = "1")
        Long id,

        @NotBlank
        @Schema(description = "게시글 제목", example = "제목이지롱")
        String title,

        @Schema(description = "게시글 내용", example = "내용이지롱")
        String content,

        @NotNull
        @Schema(description = "게시글 생성 시간", example = "2024-10-10 10:59:59")
        LocalDateTime createdAt,

        @NotNull
        @Schema(description = "게시글 수정 시간", example = "2024-10-11 10:59:59")
        LocalDateTime updatedAt) {

    public static BoardResponse of (Board board) {
        return BoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .createdAt(board.getCreatedAt())
                .updatedAt(board.getUpdatedAt())
                .build();
    }
}
