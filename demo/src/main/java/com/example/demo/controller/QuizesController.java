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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Word;
import com.example.demo.service.QuizesService;
import com.example.demo.utils.AppConstants;

@RestController
@RequestMapping("/api/quiz")
public class QuizesController {
	@Autowired
	private QuizesService quizService;
	
	@GetMapping(path="/pageNum={pageNum}")
	public List<Word> getQuizPageWord(@RequestParam(value = "pageNum", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNum){
		int pageSize = 5;
		return quizService.getQuizPageWord(pageNum, pageSize);
	}

}
