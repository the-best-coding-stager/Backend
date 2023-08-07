package com.example.demo.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.enums.ExceptionEnum;
import com.example.demo.common.response.ApiException;

import springfox.documentation.annotations.ApiIgnore;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@ApiIgnore
public class ErrorController {

    @RequestMapping("/error")
    public void error(HttpServletRequest request) throws AuthenticationException{

        String exception = (String) request.getAttribute("exception");

        if ("AuthenticationException".equals(exception)) {
            throw new ApiException(ExceptionEnum.SECURITY);
        }
    }
}
