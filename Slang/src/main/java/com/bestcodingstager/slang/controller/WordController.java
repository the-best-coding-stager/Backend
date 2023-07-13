package com.bestcodingstager.slang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bestcodingstager.slang.dto.Word;
import com.bestcodingstager.slang.service.WordService;

@RestController
public class WordController {
	
	@Autowired
	private WordService service;
	
	@GetMapping()
	public String requestWordList(Model model){
		List<Word> list = service.getAllWordList();
		model.addAttribute("wordList", list);
		return "words";
	}
	
	@GetMapping(path="/words")
	public ModelAndView requestAllWords(){
		ModelAndView modelAndView = new ModelAndView();
		List<Word> list = service.getAllWordList();
		modelAndView.addObject("wordList", list);
		modelAndView.setViewName("words");
		return modelAndView;
	}
	
	@GetMapping(path="/words/{writer_id}")
	public Word getWordByWriterId(@PathVariable String writer_id) {
		return service.getWordByWriterId(writer_id);
	}
	
	@GetMapping(path="/words/add")
	public String getAddWord() {
		return service.getAddWord();
	}
	
	@PostMapping(path="/words/add")
	public Word addWord(@RequestBody Word word) {
		service.addWord(word);
		return word;
	}
	
	@GetMapping(path="/words/word?id={id}")
	public Word getWord(@PathVariable Integer id) {
		return service.getWordById(id);
	}
	
	@PatchMapping(path="/words/word?id={id}")
	public String updateWord(@PathVariable Integer id, @RequestBody Word word) {
		return "redirect:/words/word?id={id}";
	}
	
	@DeleteMapping(path="/words/word?id={id}")
	public String deleteWord(@PathVariable Integer id) {
		service.deleteWord(id);
		return "redirect:/words";
	}
	
	@GetMapping(path="/search")
	public String getSearch() {
		return service.getSearch();
	}
	
	@GetMapping(path="/search?name={name}")
	public Word search(@PathVariable String name) {
		return service.searchWordByName(name);
	}

}
