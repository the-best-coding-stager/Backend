package com.bestcodingstager.slang.service;

import java.util.List;

import com.bestcodingstager.slang.dto.Word;

public interface WordService {

	List<Word> getAllWords();
	Word getWordById(String writer_id);

}
