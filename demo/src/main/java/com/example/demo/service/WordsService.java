package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Word;

public interface WordsService {
	
	List<Word> getAllWordList();
	Word getWordById(Integer word_id);
	List<Word> getWordsByWriterId(String writer_id);
	List<Word> getWordsByName(String name);
	void addWord(Word word);
	void updateWord(Integer word_id, Word word);
	void deleteWord(Integer word_id);

}
