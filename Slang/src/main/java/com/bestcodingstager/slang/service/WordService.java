package com.bestcodingstager.slang.service;

import java.util.List;

import com.bestcodingstager.slang.dto.Word;

public interface WordService {

	List<Word> getAllWordList();
	Word getWordByWriterId(String writer_id);
	Word getWordById(Integer id);
	Word searchWordByName(String name);
	void addWord(Word word);
	Word updateWord(Word word);
	void deleteWord(Integer id);

}
