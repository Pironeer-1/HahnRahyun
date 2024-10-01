package com.pironeer.templateCODE.global.service;

import com.pironeer.templateCODE.global.dto.response.result.ListResult;
import com.pironeer.templateCODE.global.dto.response.result.SingleResult;

import java.util.List;

public class ResponseService {
    public static <T>SingleResult<T> getSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        return result;
    }

    public static <T>ListResult<T> getListResult(List<T> list) {
        ListResult<T> result = new ListResult<>();
        result.setList(list);
        return result;
    }
}
