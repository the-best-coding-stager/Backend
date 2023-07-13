package com.bestcodingstager.slang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestcodingstager.slang.dao.WordDAO;
import com.bestcodingstager.slang.dto.Word;

@Service
public class WordServiceImpl implements WordService{
	
	@Autowired
	private WordDAO dao;

	public List<Word> getAllWordList() {
		return dao.getAllWordList();
	}
	
	public Word getWordByWriterId(String writer_id) {
		return dao.getWordByWriterId(writer_id);
	}

	public String getAddWord() {
		return "addWord";
	}

	public Word getWordById(Integer id) {
		return dao.getWordById(id);
	}

	public String getSearch() {
		return "search";
	}

	public List<Word> getWordsByName(String name) {
		return dao.getWordsByName(name);
	}

	public void addWord(Word word) {
		dao.addWord(word);
	}

	public void updateWord(Word word) {
		dao.updateWord(word);
	}

	public void deleteWord(Integer id) {
		dao.deleteWord(id);
	}

}
