package com.bestcodingstager.slang.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bestcodingstager.slang.dto.Word;

public interface WordDAO {
	List<Word> getAllWordList();
	List<Word> getWordsByWriterId(String writer_id);
	Word getWordById(Integer id);
	List<Word> getWordsByName(String name);
	void addWord(Word word);
	void updateWord(Word word);
	void deleteWord(Integer id);
}
