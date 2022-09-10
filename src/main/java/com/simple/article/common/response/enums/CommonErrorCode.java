package com.simple.article.common.response.enums;

public enum CommonErrorCode implements ErrorCode{

    ACCESS_DENIAL(-1001,"access denial");

    int code;
    String msg;
    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    CommonErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
