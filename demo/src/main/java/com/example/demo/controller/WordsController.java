package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Word;
import com.example.demo.service.WordsService;
import com.example.demo.web.exception.MyResourceNotFoundException;
import com.example.demo.web.util.RestPreconditions;
import com.google.common.base.Preconditions;

@RestController
@RequestMapping("/api/words")
public class WordsController {
	@Autowired
	private WordsService wordService;
	
	@GetMapping
	public HashMap<String, List<Word>> requestAllWords(){
		HashMap<String, List<Word>> data = new HashMap<String, List<Word>>();
		List<Word> newestList = wordService.getNewestWordsList();
		List<Word> popularList = wordService.getPopularWordsList();
		List<Word> wordList = wordService.getAllWordsList();
		
		data = wordService.merge(newestList, popularList, wordList);
		return data;
	}
	
	@GetMapping(path="/word_id={word_id}")
	public Word requestWordById(@PathVariable("word_id") Integer word_id) {
		return RestPreconditions.checkFound(wordService.getWordById(word_id));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Word create(@RequestBody Word resource) {
		Preconditions.checkNotNull(resource);
		wordService.addWord(resource);
		return resource;
	}
	
	@PatchMapping(path="/word_id={word_id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable("word_id") Integer word_id, @RequestBody Word resource) {
		Preconditions.checkNotNull(resource);
		RestPreconditions.checkFound(wordService.getWordById(resource.getWord_id()));
		wordService.updateWord(word_id, resource);
	}
	
	@GetMapping(path="/writer_id={writer_id}")
	public List<Word> getWordByWriterId(@PathVariable("writer_id") String writer_id) {
		return wordService.getWordsByWriterId(writer_id);
	}
	
	@PostMapping(path="/add")
	public Word submitAddNewWord(@RequestBody Word word) {
		wordService.addWord(word);
		return word;
	}
	
	@PatchMapping(path="/update")
	public void submitUpdateWordForm(@RequestBody Word word) {
		Integer word_id = word.getWord_id();
		wordService.updateWord(word_id, word);
	}
	
	@DeleteMapping(path="/word_id={word_id}")
	@ResponseStatus(HttpStatus.OK)
	public void getDeleteWordForm(@PathVariable("word_id") Integer word_id) {
		wordService.deleteWord(word_id);
	}
	
	@GetMapping(path="/name={name}")
	public List<Word> requestBooksByName(@PathVariable String name) {
		return wordService.getWordsByName(name);
	}
	
	public static <T> T checkFound(T resource) {
		if (resource == null) {
			throw new MyResourceNotFoundException();
		}
		return resource;
	}

}
