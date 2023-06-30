package com.bestcodingstager.slang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestcodingstager.slang.dao.UserDAO;
import com.bestcodingstager.slang.dto.User;
import com.bestcodingstager.slang.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO dao;
	
	@Override
	public List<User> getAllUsers() {	
		return dao.getAllUserList();
	}
}
