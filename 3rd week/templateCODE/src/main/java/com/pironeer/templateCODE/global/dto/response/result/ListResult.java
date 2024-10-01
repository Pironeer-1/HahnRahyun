package com.pironeer.templateCODE.global.dto.response.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class ListResult<T> {
    @Schema(description = "리스트 데이터")
    private List<T> list;
}
