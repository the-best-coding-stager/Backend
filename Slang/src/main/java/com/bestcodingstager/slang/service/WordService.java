package com.bestcodingstager.slang.service;

import java.util.List;

import com.bestcodingstager.slang.dto.Word;

public interface WordService {

	List<Word> getAllWordList();
	Word getWordByWriterId(String writer_id);
	String getAddWord();
	Word getWordById(Integer id);
	String getSearch();
	Word searchWordByName(String name);
	void addWord(Word word);
	Word updateWord(Integer id, Word word);
	void deleteWord(Integer id);

}
