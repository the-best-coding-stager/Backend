package com.example.demo.springpagination.service;

import java.util.HashMap;
import java.util.List;

import com.example.demo.springpagination.model.Word;

public interface IWordService {

    List<Word> getWordsList(int page, int size);
   
    List<Word> getUserWordsList(int page, int size);
    
    List<Word> getPopularWordsList(int page, int size);
    
	List<Word> getNewestWordsList(int page, int size);
	
	List<Word> getWordsByName(String name);
	
	HashMap<String, List<Word>> merge(List<Word> popularList, List<Word> newestList, List<Word> wordList);

    Word createWord(Word word);

    Word getWordById(Long word_id);

    void updateWord(Word word);
    
    void addWord(Word word);
    
    void deleteWord(Long word_id);

}
