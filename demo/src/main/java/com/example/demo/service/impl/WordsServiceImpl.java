package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.WordsDAO;
import com.example.demo.dto.Word;
import com.example.demo.service.WordsService;

@Service
public class WordsServiceImpl implements WordsService{
	
	@Autowired
	private WordsDAO dao;

	public List<Word> getAllWordList() {
		return dao.getAllWordList();
	}

	public Word getWordById(Integer word_id) {
		return dao.getWordById(word_id);
	}
	
	public List<Word> getWordsByWriterId(String writer_id) {
		return dao.getWordsByWriterId(writer_id);
	}

	public List<Word> getWordsByName(String name) {
		return dao.getWordsByName(name);
	}

	public void addWord(Word word) {
		dao.addWord(word);
	}

	public void updateWord(Integer word_id, Word word) {
		dao.updateWord(word_id, word);
	}

	public void deleteWord(Integer word_id) {
		dao.deleteWord(word_id);
	}

}
