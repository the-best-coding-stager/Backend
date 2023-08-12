package com.example.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.User;

@Mapper
public interface UserService {
	//List<User> signUpInfo();
	
	
	void signUpInfo(User user);	// 회원가입 요청
	
	User loadUserByUsername(String userId);
}
