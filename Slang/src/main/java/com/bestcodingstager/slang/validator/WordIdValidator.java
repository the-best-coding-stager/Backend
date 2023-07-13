package com.bestcodingstager.slang.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.bestcodingstager.slang.exception.WordIdException;
import com.bestcodingstager.slang.service.WordService;
import com.bestcodingstager.slang.dto.Word;

public class WordIdValidator implements ConstraintValidator<WordId, Integer>{
	// @Autowired
	private WordService wordService;
	
	public void initialize(WordId constraintAnnotation) {
		
	}
	
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		Word word;
		try {
			word = wordService.getWordById(value);
		} catch (WordIdException e) {
			return true;
		}
		
		if (word != null) {
			return false;
		}
		
		return true;
	}

}
