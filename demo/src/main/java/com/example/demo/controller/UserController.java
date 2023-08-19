package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
		if(!user.getPassword1().equals(user.getPassword2())) {
			//bindingResult.rejectValue("password2", "passwordIncorrect", "2개의 파스워드가 일치하지 않습니다.");
			System.out.println("Passwords are different");
			return user;
		}
		
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
		service.loadUserByUsername(user.getUserId());
		System.out.println(user.getUserId());
		return user;	//로그인 화면 리턴
	}
	
	//public String userAccess()
	
	/* 마이페이지 요청
	 * GetMapping
	 * */
	@GetMapping(path = "/mypage")
	public User MyPage(@AuthenticationPrincipal(expression ="#this =='anonymousUser'?null:user") User user) {
		if(user==null) System.out.println("User is null");
		else {
		//System.out.println(user.getNickname());
		System.out.println("Accsess Mypage");
		}
		return user;
	}
	
	/* 마이페이지 수정 페이지 요청
	 * GetMapping
	 * */
	@GetMapping(path = "/mypage/edit")
	public void MypageEditForm(@AuthenticationPrincipal User user) {
		System.out.println("This is mypageedit page");
	}
	
	/* 마이페이지 수정 요청
	 * PatchMapping
	 * */
	@PutMapping(path = "/mypage/edit")
	public User EditMypage(@RequestBody User user) {
		service.editMypage(user);
		return user;
	}
	
	
	/* 로그아웃 요청
	 * PostMapping
	 * */
	@PostMapping(path = "/logout")
	public String Logout() {
		System.out.println("print: success logout");
		return "success logout";
	}
	
	/* 회원탈퇴 요청
	 * DeleteMapping
	 * */
}
