package com.springmvc.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.springmvc.domain.Word;

public interface WordService {
	List<Word> getAllWordList();
	List<Word> getWordListByCategory(String category);
	Set<Word> getWordListByFilter(Map<String, List<String>> filter);
	Word getWordById(String wordId);
	void setNewWord(Word word);
	void setUpdateWord(Word word);
	void setDeleteWord(String wordId);
}
