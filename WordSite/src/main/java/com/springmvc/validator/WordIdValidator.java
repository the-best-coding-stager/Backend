package com.springmvc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.exception.WordIdException;
import com.springmvc.service.WordService;
import com.springmvc.domain.Word;

public class WordIdValidator implements ConstraintValidator<WordId, String>{
	
	@Autowired
	private WordService wordService;
	
	public void initialize(WordId constraintAnnotation) {		
	}
	
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Word word;
		try {
			word = wordService.getWordById(value);
		} catch (WordIdException e) {
			return true;
		}
		
		if(word != null) {
			return false;
		}
			return true;
	}
}
