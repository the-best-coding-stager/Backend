package com.bestcodingstager.slang.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bestcodingstager.slang.dto.Word;

@Repository
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

	public List<Word> getWordsByWriterId(String writer_id) {
		List<Word> wordsByWriterId = new ArrayList<Word>();
		String SQL = "SELECT count(*) FROM words where writer_id = ?";
		wordsByWriterId = template.query(SQL, new WordRowMapper());
		return wordsByWriterId;
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

	public List<Word> getWordsByName(String name) {
		List<Word> wordsByName = new ArrayList<Word>();
		String SQL = "SELECT * FROM words where name LIKE '%" + name + "%'";
		wordsByName = template.query(SQL, new WordRowMapper());
		return wordsByName;
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
