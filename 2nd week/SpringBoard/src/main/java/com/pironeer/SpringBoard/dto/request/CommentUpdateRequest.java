package com.pironeer.SpringBoard.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CommentUpdateRequest(
        @NotNull
        @Schema(description = "수정할 댓글 id", example = "1")
        Long cmtId,

        @NotBlank
        @Schema(description = "댓글 내용", example = "수정된 댓글 내용입니다")
        String cmtCnt
) {
}
