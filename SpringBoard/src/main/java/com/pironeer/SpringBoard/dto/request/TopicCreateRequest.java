package com.pironeer.SpringBoard.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// 게시물을 생성할 때 사용할 데이터를 담는 DTO
// 게시물은 제목과 내용을 가지고 있으며, 제목은 반드시 입력되어야 한다.
public record TopicCreateRequest(
        @NotBlank //아래의 필드가 null이 아니어야 하고, 공백 문자로만 이루어져 있지 않아야 함
        @Schema(description = "게시물 제목", example = "제목입니다") // Swagger문서에 설명과 예시 제공
        String title,
        @Schema(description = "게시물 내용", example = "내용입니다")
        String content) {
}
