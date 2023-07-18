package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Word;

public interface WordsService {

	List<Word> getAllWordList();
	List<Word> getWordsByWriterId(String writer_id);
	Word getWordById(Integer word_id);
	List<Word> getWordsByName(String name);
	void addWord(Word word);
	void updateWord(Word word);
	void deleteWord(Integer word_id);

}
