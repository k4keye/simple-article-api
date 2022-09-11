package com.simple.article.common.response.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@ToString
public class CollectionResult<T> extends CommonResult{
    private Collection<T> collection;
}