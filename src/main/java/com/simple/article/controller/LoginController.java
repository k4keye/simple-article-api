package com.simple.article.controller;

import com.simple.article.common.response.ResponseService;
import com.simple.article.common.response.result.Links;
import com.simple.article.common.response.result.SingleResult;
import com.simple.article.controller.dto.request.JoinRequest;
import com.simple.article.controller.dto.response.MemberDto;
import com.simple.article.domain.Member;
import com.simple.article.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * author         : raon_jh
 * date           : 2022/09/05
 * description    :
 */
@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final ResponseService responseService;
    @GetMapping
    public ResponseEntity login(@RequestParam("id") String id, @RequestParam("pwd") String pwd){

        String token = loginService.login(id, pwd);
        HashMap<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("token", "Bearer "+token);

        SingleResult<HashMap<String, String>> responseBody = responseService.getSingleResult(map);

        List<Links> links = new ArrayList<>();
        links.add(new Links("article","/article"));

        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @PostMapping("/join")
    public ResponseEntity join(@Valid @RequestBody JoinRequest joinRequest){

        Member member = loginService.join(joinRequest.getId(), joinRequest.getPwd(), joinRequest.getNickName(), joinRequest.getEmail());
        MemberDto memberDto = new MemberDto(member);

        List<Links> links = new ArrayList<>();
        links.add(new Links("login","/login"));

        SingleResult<MemberDto> responseBody = responseService.getSingleResult(memberDto,links);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }
}
