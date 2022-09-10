package com.simple.article.controller;


import com.simple.article.common.response.ResponseService;
import com.simple.article.common.response.result.Links;
import com.simple.article.common.response.result.ListResult;
import com.simple.article.common.response.result.SingleResult;
import com.simple.article.controller.dto.response.MemberDto;
import com.simple.article.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final ResponseService responseService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public ResponseEntity fetchAllMember(Pageable pageable){
        //@RequestParam("page") Integer page, @RequestParam("size") Integer size
        Page<MemberDto> members = memberService.fetchAllMember(pageable).map(MemberDto::new);

        List<Links> links = new ArrayList<>();
        links.add(new Links("detail","/member/{id}"));

        SingleResult<Page<MemberDto>> responseBody = responseService.getSingleResult(members, links);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }
}
