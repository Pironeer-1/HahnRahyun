package com.pironeer.templateCODE.global.dto.response.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SingleResult<T> {
    @Schema(description = "단일 데이터")
    private T data;
}
