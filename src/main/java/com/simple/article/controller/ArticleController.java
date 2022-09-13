package com.simple.article.controller;

import com.simple.article.common.response.ResponseService;
import com.simple.article.common.response.result.Links;
import com.simple.article.common.response.result.SingleResult;
import com.simple.article.controller.dto.request.ArticleRequest;
import com.simple.article.controller.dto.response.ArticleDto;
import com.simple.article.domain.Member;
import com.simple.article.service.ArticleService;
import com.simple.article.service.MemberService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
    private final ResponseService responseService;
    private final MemberService memberService;

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping
    public ResponseEntity fetchAllArticle(Pageable pageable){
        Page<ArticleDto> articles = articleService.fetchAll(pageable).map(ArticleDto::new);

        List<Links> links = new ArrayList<>();
        links.add(new Links("detail","/article/{id}"));

        SingleResult<Page<ArticleDto>> responseBody = responseService.getResult(articles, links);

        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity fetchArticle(@PathVariable Long id){

        ArticleDto article = new ArticleDto(articleService.fetch(id));
        SingleResult<ArticleDto> responseBody = responseService.getResult(article);

        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")//해당 api 접근 권한
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "jwt Token" , required = true, dataType = "string", paramType = "header")
    }) //swagger 에 jwt 추가 하도록 강제
    public ResponseEntity saveArticle(@Valid @RequestBody ArticleRequest articleRequest){

        Member authMember = memberService.getAuthMember();
        articleService.post(authMember,articleRequest.getTitle(), articleRequest.getContext());
        return ResponseEntity.status(HttpStatus.CREATED).body("hello world");
    }
}
