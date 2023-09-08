package com.example.demo.springpagination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.springpagination.model.User;
import com.example.demo.springpagination.repository.UserRepository;

public class LoginService implements ILoginService {
	
	// @Autowired
	// private UserRepository userRepoistory;
	
	/*

	//회원가입 요청 DAO에 연결
  	@Override
  	public void signUp(User user) {
  		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
  		user.setPassword(passwordEncoder.encode(user.getPassword()));
  		user.setUser_id(user.getNickname());
  		user.setNickname(user.getNickname());
  		userRepoistory.signUp(user);		
  	}
  	
  	@Override
  	public User loadUserByUsername(String userId) throws UsernameNotFoundException{
  		User user = userRepoistory.signIn(userId);
  		if(user == null) {
  			throw new UsernameNotFoundException("User not authorized.");
  		}
  		return user;
  	}
  	
  	*/

}
