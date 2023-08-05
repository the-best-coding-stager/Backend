package com.example.demo.service.impl;

import java.util.HashMap;
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

	public List<Word> getAllWordsList() {
		return dao.getAllWordsList();
	}

	public List<Word> getPopularWordsList() {
		return dao.getPopularWordsList();
	}

	public List<Word> getNewestWordsList() {
		return dao.getNewestWordsList();
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
	
	public HashMap<String, List<Word>> merge(List<Word> popularList, List<Word> newestList, List<Word> wordList) {
		@SuppressWarnings("serial")
		HashMap<String, List<Word>> result = new HashMap<String, List<Word>>() {{
			put("newestList", newestList);
			put("popularList", popularList);
			put("wordList", wordList);
		}};
		
		return result;
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
