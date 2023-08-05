package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import com.example.demo.dto.Word;

public interface QuizesService {
	List<Word> getQuizPageWord(int pageNum, int pageSize);

}
