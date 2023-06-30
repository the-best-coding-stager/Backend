package com.bestcodingstager.slang.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bestcodingstager.slang.dto.Word;

@Repository
public interface WordDAO {
	
	List<Word> getAllWordList();
	Word getWordById(String writer_id);

}
