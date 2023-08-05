package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.dto.User;

@Repository
public interface UserDAO {
	List<User> testUser();
	
	void signUp(User user);	// 회원가입 유저 정보 DB에 
	
	User signIn(String userId);	// 로그인
}
