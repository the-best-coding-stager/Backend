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

	public Word searchWordByName(String name) {
		return dao.getWordByName(name);
	}

	public void addWord(Word word) {
		dao.addWord(word);
		return ;
	}

	public Word updateWord(Integer id, Word word) {
		Word updatedWord = new Word();
		
		dao.updateWord(id, word);
		
		updatedWord.setName(word.getName());
		updatedWord.setTitle(word.getTitle());
		updatedWord.setDescription(word.getDescription());
		updatedWord.setWriter_id(word.getWriter_id());
		
		return updatedWord;
	}

	public void deleteWord(Integer id) {
		dao.deleteWord(id);
		return ;
	}

}
