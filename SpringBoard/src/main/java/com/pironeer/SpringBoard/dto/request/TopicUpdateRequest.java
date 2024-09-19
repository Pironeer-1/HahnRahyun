package com.pironeer.SpringBoard.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// 게시물을 수정할 때 사용할 데이터를 담는 DTO
// 왜 게시물 ID에는 NotNull을 썼을까 -> Long 타입이라
public record TopicUpdateRequest(
        @NotNull // 빈 값이나 공백은 허용되지만, null은 허용되지 않음
        @Schema(description = "게시물 ID", example = "1")
        Long id,
        @NotBlank
        @Schema(description = "수정할 게시물 제목", example = "제목을 수정합니다")
        String title,
        @Schema(description = "수정할 게시물 내용", example = "내용을 수정합니다")
        String content) {
}
