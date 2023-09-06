package com.example.demo.springpagination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.springpagination.model.User;
import com.example.demo.springpagination.model.Word;

public interface UserRepository extends JpaRepository<Word, Long> {

	void signUp(User user);	// 회원가입 유저 정보 DB에 
	
	User signIn(String userId);	// 로그인

}
