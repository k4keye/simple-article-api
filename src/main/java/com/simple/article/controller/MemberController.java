package com.simple.article.controller;


import com.simple.article.common.response.ResponseService;
import com.simple.article.common.response.enums.CommonErrorCode;
import com.simple.article.common.response.result.Links;
import com.simple.article.common.response.result.SingleResult;
import com.simple.article.controller.dto.response.MemberDto;
import com.simple.article.domain.Member;
import com.simple.article.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

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

        SingleResult<Page<MemberDto>> responseBody = responseService.getResult(members, links);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity fetchMember(@PathVariable String id){

        Member authMember = memberService.getAuthMember();

        if(authMember.isAdmin() || authMember.getLoginID().equals(id)){
            Member member = memberService.fetchMember(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseService.getResult(new MemberDto(member)));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseService.getFailResult(CommonErrorCode.ACCESS_DENIAL));

    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteMember(@PathVariable String id){

        Member authMember = memberService.getAuthMember();

        if(authMember.isAdmin() || authMember.getLoginID().equals(id)){
            memberService.delete();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(responseService.getSuccessResult());
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseService.getFailResult(CommonErrorCode.ACCESS_DENIAL));
    }
}
