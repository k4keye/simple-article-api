package com.simple.article.common.response.result;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListResult<T> extends CommonResult{
    private List<T> list;

    @Override
    public String toString() {
        return "ListResult{" +
                "list=" + list +
                '}';
    }
}