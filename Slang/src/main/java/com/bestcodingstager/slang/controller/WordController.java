package com.bestcodingstager.slang.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bestcodingstager.slang.dto.Word;
import com.bestcodingstager.slang.exception.SearchException;
import com.bestcodingstager.slang.service.WordService;
import com.bestcodingstager.slang.validator.WordValidator;

@RestController
@RequestMapping("/words")
public class WordController {
	
	@Autowired
	private WordService wordService;
	
	@GetMapping()
	public List<Word> requestWordList(){
		return wordService.getAllWordList();

	}
	
	@GetMapping(path="/")
	public List<Word> requestAllWords(){
		return wordService.getAllWordList();
	}
	
	@GetMapping(path="?{writer_id}")
	public List<Word> getWordByWriterId(@PathVariable String writer_id) {
		return wordService.getWordsByWriterId(writer_id);
	}
	
	@GetMapping(path="/add")
	public String requestAddWordForm(Word word) {
		return "addWord";
	}
	
	@PostMapping(path="/add")
	public Word submitAddNewWord(@RequestBody Word word) {
		wordService.addWord(word);
		return word;
	}
	
	@GetMapping(path="?id={id}")
	public Word requestWordById(@PathVariable Integer id) {
		return wordService.getWordById(id);
	}
	
	@GetMapping("/update")  
    public Word getUpdateWordForm(Word word, @RequestParam("id") Integer wordId) {
        return wordService.getWordById(wordId);
    }  
	
	@PatchMapping(path="/update")
	public void submitUpdateWordForm(Word word) {
		wordService.updateWord(word);
	}
	
	@DeleteMapping(path="?id={id}")
	public void getDeleteWordForm(@PathVariable Integer id) {
		wordService.deleteWord(id);
	}
	
	@GetMapping(path="?name={name}")
	public List<Word> requestBooksByName(@PathVariable String name) {
		return wordService.getWordsByName(name);
	}

}
