package com.pironeer.SpringBoard.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CommentCreateRequest(
        // 댓글을 생성할 때 필요한 데이터를 클라이언트에게 받음
        @NotNull
        Long topic_id, // 소속 게시물의 id, null이면 안됨
        Long parent_id, // 부모 댓글의 id, 값이 null이면 댓글 있으면 대댓글

        @NotBlank // 댓글 내용에 null 또는 빈 문자열 안됨
        //@Schema(description = "댓글 내용", example = "내용입니다")
        String cmt_cnt) {
}
