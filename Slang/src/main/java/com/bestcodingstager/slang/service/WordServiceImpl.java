package com.bestcodingstager.slang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bestcodingstager.slang.dao.WordDAO;
import com.bestcodingstager.slang.dto.Word;

public class WordServiceImpl implements WordService{
	
	@Autowired
	private WordDAO dao;

	public List<Word> getAllWords() {
		return dao.getAllWordList();
	}
	
	public Word getWordById(String writer_id) {
		return dao.getWordById(writer_id);
	}

}
