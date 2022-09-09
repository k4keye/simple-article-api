package com.simple.article.controller;

import com.simple.article.controller.dto.request.ArticleRequest;
import com.simple.article.service.ArticleService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * author         : raon_jh
 * date           : 2022/09/05
 * description    :
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")//해당 api 접근 권한
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "jwt Token" , required = true, dataType = "string", paramType = "header")
    }) //swagger 에 jwt 추가 하도록 강제
    public ResponseEntity saveArticle(@Valid @RequestBody ArticleRequest articleRequest){

        articleService.saveArticle(articleRequest.getTitle(), articleRequest.getContext());
        return ResponseEntity.status(HttpStatus.CREATED).body("hello world");
    }
}
