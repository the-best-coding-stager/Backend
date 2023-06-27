package com.springmvc.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Word;
import com.springmvc.repository.WordRepository;

@Service
public class WordServiceImpl implements WordService{
	@Autowired
	private WordRepository wordRepository;
	
	@Override
	public List<Word> getAllWordList() {
		return wordRepository.getAllWordList();
	}
	
	public List<Word> getWordListByCategory(String category){
		List<Word> wordListByCategory = wordRepository.getWordListByCategory(category);
		return wordListByCategory;
	}
	
	public Set<Word> getWordListByFilter(Map<String, List<String>> filter){
		Set<Word> wordsByFilter = wordRepository.getWordListByFilter(filter);
		return wordsByFilter;
	}
	
	public Word getWordById(String wordId) {
		Word wordById = wordRepository.getWordById(wordId);
		return wordById;
	}

	public void setNewWord(Word word) {
		wordRepository.setNewWord(word);
	}

	public void setUpdateWord(Word word) {
		wordRepository.setUpdateWord(word);
	}

	public void setDeleteWord(String wordID) {
		wordRepository.setDeleteWord(wordID);
	}

}
