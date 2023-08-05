package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import com.example.demo.dto.Word;

public interface WordsService {	
	List<Word> getAllWordsList();
	List<Word> getPopularWordsList();
	List<Word> getNewestWordsList();
	Word getWordById(Integer word_id);
	List<Word> getWordsByWriterId(String writer_id);
	List<Word> getWordsByName(String name);
	HashMap<String, List<Word>> merge(List<Word> popularList, List<Word> newestList, List<Word> wordList);
	void addWord(Word word);
	void updateWord(Integer word_id, Word word);
	void deleteWord(Integer word_id);
}
