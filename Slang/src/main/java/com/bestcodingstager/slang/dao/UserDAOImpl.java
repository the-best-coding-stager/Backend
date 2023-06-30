package com.bestcodingstager.slang.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bestcodingstager.slang.dto.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	private JdbcTemplate template;
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

	public List<User> getAllUserList() {
		String SQL = "SELECT * FROM users";
		List<User> listOfUsers = template.query(SQL, new UserRowMapper());
		return listOfUsers;
	}

}
