package com.example.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.dto.User;

public interface UserService {
	//List<User> signUpInfo();
	
	
	void signUpInfo(User user);	// 회원가입 요청
	
	UserDetails loadUserByUsername(String userId);
}
