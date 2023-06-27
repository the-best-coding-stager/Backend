package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Word;

public class WordRowMapper implements RowMapper<Word>{
	public Word mapRow(ResultSet rs, int rowNum) throws SQLException {
		Word word = new Word();
		word.setWordId(rs.getString(1));
		word.setName(rs.getString(2));
		word.setTitle(rs.getString(3));
		word.setDescription(rs.getString(4));
		word.setWriter(rs.getString(5));
		word.setReleaseDate(rs.getString(6));
		return word;
	}
}
