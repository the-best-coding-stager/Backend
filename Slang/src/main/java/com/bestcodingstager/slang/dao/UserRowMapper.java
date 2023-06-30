package com.bestcodingstager.slang.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bestcodingstager.slang.dto.User;

public class UserRowMapper implements RowMapper<User>{
	
	public User mapRow(ResultSet rs, int rowNum) throws SQLException{
		User user = new User();
		user.setId(rs.getString(1));
		user.setNickname(rs.getString(2));
		user.setPassword(rs.getString(3));
		
		return user;
	}
}
