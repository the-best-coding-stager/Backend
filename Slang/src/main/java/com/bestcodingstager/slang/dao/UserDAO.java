package com.bestcodingstager.slang.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bestcodingstager.slang.dto.User;

@Repository
public interface UserDAO {
	List<User> getAllUserList();
}
