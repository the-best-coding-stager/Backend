package com.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;

import com.springmvc.domain.Word;
import com.springmvc.service.WordService;
import com.springmvc.exception.WordIdException;
import com.springmvc.validator.WordValidator;

@Controller
@RequestMapping("/words")
public class WordController {
	
	@Autowired
	private WordService wordService;
	
	@Autowired
	private WordValidator wordValidator;
	
	@GetMapping
	public String requestWordList(Model model) {
		List<Word> list = wordService.getAllWordList();
		model.addAttribute("wordList", list);
		return "words";
	}
	
	@GetMapping("/all")
	public ModelAndView requestAllWords() {
		ModelAndView modelAndView = new ModelAndView();
		List<Word> list = wordService.getAllWordList();
		modelAndView.addObject("wordList", list);
		modelAndView.setViewName("words");
		return modelAndView;
	}
	
	@GetMapping("/word")
	public String requesWordById(@RequestParam("id") String wordId, Model model) {
		Word wordById = wordService.getWordById(wordId);
		model.addAttribute("word", wordById);
		return "word";
	}
	
	 @GetMapping("/add")  
	    public String requestAddWordForm(@ModelAttribute("NewWord") Word word) {  
	        return "addWord";
	    }  
		
	 @PostMapping("/add") 
	    public String submitAddNewWord(@Valid @ModelAttribute("NewWord") Word word, BindingResult result) {
		 
		 if(result.hasErrors())
			 return "addWord";

		 wordService.setNewWord(word);
		 return "redirect:/words";
	}
	
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("addTitle", "신규 단어 등록");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(wordValidator);
		binder.setAllowedFields("wordId", "name", "title", "description", "writer", "releaseDate");
	}
	
	@ExceptionHandler(value={WordIdException.class})
	public ModelAndView handleError(HttpServletRequest req, WordIdException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidWordId", exception.getWordId());
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL() + "?" + req.getQueryString());
		mav.setViewName("errorWord");
		return mav;
	}
	
	@GetMapping("/update")  
    public String getUpdateWordForm(@ModelAttribute("updateWord") Word word, @RequestParam("id") String wordId, Model model) {
		Word wordById = wordService.getWordById(wordId);
        model.addAttribute("word", wordById);
        return "updateForm";
    }  

    @PostMapping("/update") 
    public String submitUpdateWordForm(@ModelAttribute("updateword") Word word) {
        wordService.setUpdateWord(word);
        return "redirect:/words";
    }  
    
    @RequestMapping(value = "/delete") 
    public String getDeleteWordForm(Model model, @RequestParam("id") String wordId) {
        wordService.setDeleteWord(wordId);
        return "redirect:/words";
    }
}
