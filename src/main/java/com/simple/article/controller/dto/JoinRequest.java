package com.simple.article.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * author         : raon_jh
 * date           : 2022/09/05
 * description    :
 */
@Getter
@NoArgsConstructor
public class JoinRequest {
    @NotBlank(message = "파라미터가 비워져있다.")
    private String id;
    @NotBlank
    private String pwd;
    @NotBlank
    private String nickName;
    @NotBlank
    private String email;
}
