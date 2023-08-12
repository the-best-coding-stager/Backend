package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.User;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping(value="/api")
@RequiredArgsConstructor
public class UserController {
	
	@Autowired
	private UserService service;
	
	/* 회원가입 폼 요청
	 * GetMapping
	 * */
	@GetMapping(path = "/signup")
	public void signUpForm() {
		System.out.println("This is a signupform");
	}
	
	/* 회원가입 요청
	 * PostMapping
	 * */
	@PostMapping(path = "/signup")
	public User signUp(@RequestBody User user /*, BindingResult bindingResult*/) {
		// 프론트 단에서 쏘아주는 아이디, 닉네임, 비번
		// 받아서, DB에 넣기
//		if(bindingResult.hasErrors()) {
//			return "Fail signup";
//		}
//		
//		if(!user.getPassword1().equals(user.getPassword2())) {
//			bindingResult.rejectValue("password2", "passwordIncorrect", "2개의 파스워드가 일치하지 않습니다.");
//			return "Passwords are different";
//		}
		
		service.signUpInfo(user);
		System.out.println("Success");
		return user;
		//return "Success signup";	// 로그인한 메인화면 리턴
	}
	
	/* 로그인 폼 요청
	 * GetMapping
	 * */
	@GetMapping(path = "/login")
	public void logInForm() {
		System.out.println("This is a loginform");
	}
	
	/* 로그인 요청
	 * PostMapping
	 * */
	@PostMapping(path = "/login")
	public User logIn(@RequestBody User user) {
		
		
		return user;	//로그인 화면 리턴
	}
	
	//public String userAccess()
	
	/* 마이페이지 요청
	 * GetMapping
	 * */
}
