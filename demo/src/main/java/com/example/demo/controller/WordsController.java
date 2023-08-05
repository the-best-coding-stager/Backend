package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Word;
import com.example.demo.service.WordsService;

@RestController
@RequestMapping("/api/words")
public class WordsController {
	@Autowired
	private WordsService wordService;
	
	@GetMapping
	public HashMap<String, List<Word>> requestAllWords(){
		HashMap<String, List<Word>> data = new HashMap<String, List<Word>>();
		List<Word> popularList = wordService.getPopularWordsList();
		List<Word> newestList = wordService.getNewestWordsList();
		List<Word> wordList = wordService.getAllWordsList();
		
		data = wordService.merge(popularList, newestList, wordList);
		return data;
	}
	
	@GetMapping(path="/word_id={word_id}")
	public Word requestWordById(@PathVariable Integer word_id) {
		return wordService.getWordById(word_id);
	}
	
	@GetMapping(path="/writer_id={writer_id}")
	public List<Word> getWordByWriterId(@PathVariable String writer_id) {
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
	public void getDeleteWordForm(@PathVariable Integer word_id) {
		wordService.deleteWord(word_id);
	}
	
	@GetMapping(path="/name={name}")
	public List<Word> requestBooksByName(@PathVariable String name) {
		return wordService.getWordsByName(name);
	}

}
