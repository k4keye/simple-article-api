package com.simple.article.common.response;


import com.simple.article.common.response.enums.ResultCode;
import com.simple.article.common.response.result.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ResponseService {

    // enum으로 api 요청 결과에 대한 code, message를 정의합니다.
    public enum CommonResponse {
        SUCCESS(0, "성공하였습니다.");

        int code;
        String msg;

        CommonResponse(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    // 단일건 결과를 처리하는 메소드
    public <T> SingleResult<T> getSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        setSuccessResult(result);
        return result;
    }

    public <T> SingleResult<T> getSingleResult(T data, List<Links> links) {
        SingleResult<T> singleResult = getSingleResult(data);
        singleResult.setLinks(links);
        return singleResult;
    }


    public <T> SingleResult<T> getSingleResult(T data, ResultCode resultCode) {
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        setSuccessResult(result, resultCode);
        return result;
    }

    // 다중건 결과를 처리하는 메소드
    public <T> ListResult<T> getListResult(List<T> list) {
        ListResult<T> result = new ListResult<>();
        result.setList(list);
        setSuccessResult(result);
        return result;
    }

    public <T> ListResult<T> getListResult(List<T> list, ResultCode resultCode) {
        ListResult<T> result = new ListResult<>();
        result.setList(list);
        setSuccessResult(result, resultCode);
        return result;
    }

    // 다중건 결과를 처리하는 메소드
    public <T> SetResult<T> getSetResult(Set<T> set) {
        SetResult<T> result = new SetResult<>();
        result.setSet(set);
        setSuccessResult(result);
        return result;
    }

    public <T> SetResult<T> getSetResult(Set<T> set, ResultCode resultCode) {
        SetResult<T> result = new SetResult<>();
        result.setSet(set);
        setSuccessResult(result, resultCode);
        return result;
    }

    // 실패 결과만 처리하는 메소드
    public CommonResult getFailResult(String msg) {
        return new CommonResult(false, -1, msg);
    }

    public CommonResult getFailResult(int code, String msg) {
        return new CommonResult(false, code, msg);
    }

    public CommonResult getFailResult(ResultCode resultCode) {
        return getFailResult(resultCode.getCode(), resultCode.getMsg());
    }

    public <T> SingleResult<T> getFailDataResult(ResultCode resultCode, T data) {
        SingleResult<T> result = new SingleResult<>(data);
        setFailResult(resultCode, result);
        return result;
    }

    private void setFailResult(ResultCode resultCode, CommonResult result) {
        result.setSuccess(false);
        result.setCode(resultCode.getCode());
        result.setMsg(resultCode.getMsg());
    }

    // 성공 결과만 처리하는 메소드
    public CommonResult getSuccessResult() {
        CommonResult result = new CommonResult();
        setSuccessResult(result);
        return result;
    }

    public CommonResult getSuccessResult(ResultCode resultCode) {
        CommonResult result = new CommonResult();
        setSuccessResult(result);
        result.setCode(resultCode.getCode());
        result.setMsg(resultCode.getMsg());
        return result;
    }

    // 결과 모델에 api 요청 성공 데이터를 세팅해주는 메소드
    private void setSuccessResult(CommonResult result) {
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }

    private void setSuccessResult(CommonResult result, ResultCode resultCode) {
        result.setSuccess(true);
        result.setCode(resultCode.getCode());
        result.setMsg(resultCode.getMsg());
    }

    // 문자열 결과만 처리하는 메서드
    @Deprecated
    public StringResult getStringResult(String body) {
        StringResult result = new StringResult();
        result.setData(body);
        setSuccessResult(result);
        return result;
    }
}