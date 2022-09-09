package com.simple.article.common.response.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StringResult  extends CommonResult{
    private String data;

    @Override
    public String toString() {
        return "StringResult{" +
                "data='" + data + '\'' +
                '}';
    }
}