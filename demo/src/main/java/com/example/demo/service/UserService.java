package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.User;

public interface UserService {
	//List<User> signUpInfo();
	
	void signUpInfo(User user);	// 회원가입 요청
	
	User loadUserByUsername(String userId);
}
