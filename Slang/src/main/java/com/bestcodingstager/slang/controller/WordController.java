package com.bestcodingstager.slang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bestcodingstager.slang.dto.*;
import com.bestcodingstager.slang.service.WordService;

@RestController
public class WordController {
	
	@Autowired
	private WordService service;
	
	@GetMapping(path="/words")
	public List<Word> getAllWords(){
		return service.getAllWords();
	}
	
	@GetMapping(path="/words/{writer_id}")
	public Word getWord(@PathVariable String writer_id) {
		return service.getWordById(writer_id);
	}

}
