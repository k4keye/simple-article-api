package com.simple.article.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class ArticleRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String context;

}
