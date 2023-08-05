package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dao.QuizesDAO;
import com.example.demo.dao.WordsDAO;
import com.example.demo.dto.Word;
import com.example.demo.service.QuizesService;

@Service
public class QuizesServiceImpl implements QuizesService{
	@Autowired
	private QuizesDAO dao;
	
	public List<Word> getQuizPageWord(int pageNum, int pageSize) {
		List<Word> sort = dao.getRandomWordsList();
		return null;
	}

}
