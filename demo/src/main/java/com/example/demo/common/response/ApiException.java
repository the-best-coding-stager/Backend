package com.example.demo.common.response;

import com.example.demo.common.enums.ExceptionEnum;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {
    private ExceptionEnum error;
    
    // 아래 예외 처리
    // throw new ApiException(ExceptionEnum.SECURITY_01);
    public ApiException(ExceptionEnum e) {
        super(e.getMessage());
        this.error = e;
    }
}