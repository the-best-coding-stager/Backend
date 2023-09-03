package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.requestresponsebody.LoginForm;

@Service
public class ExampleService {

    public boolean fakeAuthenticate(LoginForm lf) {
        return true;
    }
}