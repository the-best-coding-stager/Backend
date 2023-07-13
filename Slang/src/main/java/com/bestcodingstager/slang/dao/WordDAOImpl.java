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

	public Word getWordByWriterId(String writer_id) {
		Word wordInfo = null;
		String SQL = "SELECT count(*) FROM words where writer_id = ?";
		int rowCount = template.queryForObject(SQL, Integer.class, writer_id);
		if (rowCount != 0) {
			SQL = "SELECT * FROM words where writer_id = ?";
			wordInfo = template.queryForObject(SQL, new Object[] {writer_id}, new WordRowMapper());
		}
		return wordInfo;
	}

	public Word getWordById(Integer id) {
		Word wordInfo = null;
		String SQL = "SELECT count(*) FROM words where id = ?";
		int rowCount = template.queryForObject(SQL, Integer.class, id);
		if (rowCount != 0) {
			SQL = "SELECT * FROM words where id = ?";
			wordInfo = template.queryForObject(SQL, new Object[] {id}, new WordRowMapper());
		}
		return wordInfo;
	}

	public Word getWordByName(String name) {
		Word wordInfo = null;
		String SQL = "SELECT count(*) FROM words name = ?";
		int rowCount = template.queryForObject(SQL, Integer.class, name);
		if (rowCount != 0) {
			SQL = "SELECT * FROM words where name = ?";
			wordInfo = template.queryForObject(SQL, new Object[] {name}, new WordRowMapper());
		}
		return wordInfo;
	}

	public void addWord(Word word) {
		String SQL = "INSERT INTO words (id, name, title, description, writer_id) " + "VALUES (?, ?, ?, ?, ?)";

        template.update(SQL, word.getId(), word.getName(), word.getTitle(), word.getDescription(), word.getWriter_id());
        return;
	}

	public void updateWord(Word word) {
		String SQL = "UPDATE words SET name = ?, title = ?, description = ?, writer_id = ? where id = ?";
		
		template.update(SQL, word.getName(), word.getTitle(), word.getDescription(), word.getWriter_id(), word.getId());
		return;
	}

	public void deleteWord(Integer id) {
		String SQL = "DELETE from words where id = ?";
		this.template.update(SQL, id);
	}

}
