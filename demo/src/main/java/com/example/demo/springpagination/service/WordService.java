package com.example.demo.springpagination.service;

import java.util.HashMap;
import java.util.List;

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
    public List<Word> getWordsList(int page, int size) {

        PageRequest pageReq
        = PageRequest.of(page, size);

        Page<Word> words = wordRepository.findAll(pageReq);
        return words.getContent();
    }

    @Override
    public List<Word> getUserWordsList(int page, int size) {

        PageRequest pageReq
        = PageRequest.of(page, size);

        Page<Word> words = wordRepository.findByUser(userService.getCurrentUser(), pageReq);
        return words.getContent();
    }
    
    @Override
	public List<Word> getPopularWordsList(int page, int size) {

        PageRequest pageReq
        = PageRequest.of(page, size);

    	Page<Word> words = wordRepository.findPopular(pageReq);
        return words.getContent();
	}

	@Override
	public List<Word> getNewestWordsList(int page, int size) {

        PageRequest pageReq
        = PageRequest.of(page, size);
		
        Page<Word> words = wordRepository.findNewest(pageReq);
        return words.getContent();
	}

	@Override
	public List<Word> getWordsByName(String name, int page, int size) {

        PageRequest pageReq
        = PageRequest.of(page, size);
		
        Page<Word> words = wordRepository.findName(name, pageReq);
        return words.getContent();
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
	public void deleteWord(Long word_id) {
		wordRepository.deleteById(word_id);
	}

}
