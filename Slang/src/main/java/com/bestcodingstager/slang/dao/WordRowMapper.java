package com.bestcodingstager.slang.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bestcodingstager.slang.dto.Word;

public class WordRowMapper implements RowMapper<Word> {

	public Word mapRow(ResultSet rs, int rowNum) throws SQLException {
		Word word = new Word();
		word.setId(rs.getInt(1));
		word.setName(rs.getString(2));
		word.setTitle(rs.getString(3));
		word.setDescription(rs.getString(4));
		word.setWriter_id(rs.getString(5));
		
		return word;
	}

}
