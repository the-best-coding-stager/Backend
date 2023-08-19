package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.User;

@Repository
@Mapper
public interface UserDAO {
	List<User> testUser();
	
	void signUpInfo(User user);	// 회원가입 유저 정보 DB에 
	
	User getUserAccount(String userId);	// 로그인
	
	User findByUserid(String userId);	// 유저 아이디로 찾기
	
	void update(User user);	// 마이페이지 수정, DB 업데이트
}
