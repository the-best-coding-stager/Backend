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
	
	// @Autowired(required=false)
	private WordService wordService;
	
	private WordValidator wordValidator;
	
	@GetMapping()
	public String requestWordList(Model model){
		List<Word> list = wordService.getAllWordList();
		model.addAttribute("wordList", list);
		return "words";
	}
	
	@GetMapping(path="/")
	public ModelAndView requestAllWords(){
		ModelAndView modelAndView = new ModelAndView();
		List<Word> list = wordService.getAllWordList();
		modelAndView.addObject("wordList", list);
		modelAndView.setViewName("words");
		return modelAndView;
	}
	
	@GetMapping(path="/{writer_id}")
	public Word getWordByWriterId(@PathVariable String writer_id) {
		return wordService.getWordByWriterId(writer_id);
	}
	
	@GetMapping(path="/add")
	public String requestAddWordForm(@ModelAttribute("NewWord") Word word) {
		return "addWord";
	}
	
	@PostMapping(path="/add")
	public String submitAddNewWord(@Valid @RequestBody Word word, BindingResult result) {
		if (result.hasErrors()) {
			return "addBook";
		}
		
		wordService.addWord(word);
		return "redirect:/words";
	}
	
	@GetMapping(path="/word?id={id}")
	public String requestWordById(@PathVariable Integer id, Model model) {
		Word wordById = wordService.getWordById(id);
		model.addAttribute("word", wordById);
		return "word";
	}
	
	@GetMapping("/update")  
    public String getUpdateWordForm(@ModelAttribute("updateWord") Word word, @RequestParam("id") Integer wordId, Model model) {
		Word wordById = wordService.getWordById(wordId);
        model.addAttribute("book", wordById);
        return "updateForm";
    }  
	
	@PatchMapping(path="/update")
	public String submitUpdateWordForm(@ModelAttribute("updateWord") Word word) {
		wordService.updateWord(word);
		return "redirect:/words";
	}
	
	@DeleteMapping(path="/word?id={id}")
	public String getDeleteWordForm(Model model, @PathVariable Integer id) {
		wordService.deleteWord(id);
		return "redirect:/words";
	}
	
	@GetMapping(path="/word?name={name}")
	public String requestBooksByName(@PathVariable String name, Model model) {
		List<Word> wordsByName = wordService.getWordsByName(name);
		if (wordsByName == null || wordsByName.isEmpty()) {
			throw new SearchException();
		}
		model.addAttribute("wordList", wordsByName);
		return "search";
	}

}
