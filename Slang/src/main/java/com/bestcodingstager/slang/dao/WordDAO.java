package com.bestcodingstager.slang.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bestcodingstager.slang.dto.Word;

@Repository
public interface WordDAO {
	
	List<Word> getAllWordList();
	Word getWordByWriterId(String writer_id);
	Word getWordById(Integer id);
	Word getWordByName(String name);
	void addWord(Word word);
	void updateWord(Integer id, Word word);
	void deleteWord(Integer id);
}
