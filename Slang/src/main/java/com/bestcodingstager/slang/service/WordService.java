package com.bestcodingstager.slang.service;

import java.util.List;

import com.bestcodingstager.slang.dto.Word;

public interface WordService {

	List<Word> getAllWordList();
	Word getWordByWriterId(String writer_id);
	Word getWordById(Integer id);
	List<Word> getWordsByName(String name);
	void addWord(Word word);
	void updateWord(Word word);
	void deleteWord(Integer id);

}
