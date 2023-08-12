package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserDAO;
import com.example.demo.dto.User;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	private UserDAO dao;

	/*
	@Override
	public List<User> signUpInfo() {
		User user = new User();
		
		return dao.testUser();
	}
	*/

	//회원가입 요청 DAO에 연결
	@Override
	@Transactional
	public void signUpInfo(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword1(passwordEncoder.encode(user.getPassword1()));
		user.setUserId(user.getUserId());
		user.setNickname(user.getNickname());
		user.setUserRole("USER");
		dao.signUpInfo(user);
		
	}
	
	@Override
	public User loadUserByUsername(String userId) throws UsernameNotFoundException{
		User user = dao.getUserAccount(userId);
		if(user == null) {
			throw new UsernameNotFoundException("User not authorized.");
		}
		return user;
	}


	
}
