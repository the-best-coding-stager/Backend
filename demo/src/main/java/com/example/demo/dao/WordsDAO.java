package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Word;

@Repository
public interface WordsDAO {
	List<Word> getAllWordList();
	List<Word> getWordsByWriterId(String writer_id);
	Word getWordById(Integer word_id);
	List<Word> getWordsByName(String name);
	void addWord(Word word);
	void updateWord(@Param("word") Word word);
	void deleteWord(Integer word_id);
}
