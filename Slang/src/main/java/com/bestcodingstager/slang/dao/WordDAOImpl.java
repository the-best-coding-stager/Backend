package com.bestcodingstager.slang.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bestcodingstager.slang.dto.Word;

public class WordDAOImpl implements WordDAO{
	
private JdbcTemplate template;
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

	public List<Word> getAllWordList() {
		String SQL = "SELECT * FROM words";
		List<Word> listOfWords = template.query(SQL, new WordRowMapper());
		return listOfWords;
	}

	public Word getWordById(String writer_id) {
		Word wordInfo = null;
		String SQL = "SELECT count(*) FROM word where writer_id=?";
		int rowCount = template.queryForObject(SQL, Integer.class, writer_id);
		if (rowCount != 0) {
			SQL = "SELECT * FROM word where writer_id=?";
			wordInfo = template.queryForObject(SQL, new Object[] {writer_id}, new WordRowMapper());
		}
		return wordInfo;
	}

}
