package com.simple.article.controller;

import com.simple.article.controller.dto.JoinRequest;
import com.simple.article.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @GetMapping
    public ResponseEntity login(@RequestParam("id") String id, @RequestParam("pwd") String pwd){
        loginService.login(id,pwd);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PostMapping("/join")
    public ResponseEntity join(@Valid @RequestBody JoinRequest joinRequest){
        loginService.join(joinRequest.getId(), joinRequest.getPwd(), joinRequest.getNickName(), joinRequest.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
