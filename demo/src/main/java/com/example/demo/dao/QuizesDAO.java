package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Word;

@Repository
public interface QuizesDAO {
	List<Word> getAllWordsList();
	List<Word> getRandomWordsList();
}
