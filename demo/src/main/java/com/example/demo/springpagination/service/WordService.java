package com.example.demo.springpagination.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.springpagination.model.Word;
import com.example.demo.springpagination.repository.WordRepository;


@Service
public class WordService implements IWordService{
	
	@Autowired
    private WordRepository wordRepository;
    
    @Autowired
    private IUserService userService;

    @Override
    public List<Word> getWordsList(int page, int size, String sortDir, String sort) {

        PageRequest pageReq
        = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sort);

        Page<Word> words = wordRepository.findAll(pageReq);
        return words.getContent();
    }

    @Override
    public List<Word> getUserWordsList(int page, int size, String sortDir, String sort) {

        PageRequest pageReq
        = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sort);

        Page<Word> words = wordRepository.findByUser(userService.getCurrentUser(), pageReq);
        return words.getContent();
    }
    
    @Override
	public List<Word> getPopularWordsList() {

    	Page<Word> words = wordRepository.findPopular();
        return words.getContent();
	}

	@Override
	public List<Word> getNewestWordsList() {
		
        Page<Word> words = wordRepository.findNewest();
        return words.getContent();
	}

	@Override
	public List<Word> getWordsByName(String name) {
		return null;
	}

	@Override
	public HashMap<String, List<Word>> merge(List<Word> popularList, List<Word> newestList, List<Word> wordList) {
		return null;
	}

    @Override
    public Word createWord(Word word) {
        return wordRepository.save(word);
    }

    @Override
    public Word getWordById(Long id) {
        return wordRepository.getOne(id);
    }
    
    @Override
    public void updateWord(Word word) {
    	wordRepository.save(word);
    }
    
	@Override
	public void addWord(Word word) {
		
	}

	@Override
	public void deleteWord(Long word_id) {
		wordRepository.deleteById(word_id);
	}

}
