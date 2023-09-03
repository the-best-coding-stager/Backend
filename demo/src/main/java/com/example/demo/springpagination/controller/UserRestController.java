package com.example.demo.springpagination.controller;

import com.example.demo.springpagination.dto.WordDto;
import com.example.demo.springpagination.model.Word;
import com.example.demo.springpagination.service.IWordService;
import com.example.demo.springpagination.service.IUserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/mypage")
public class UserRestController {
	
	@Autowired
    private IWordService wordService;
 
    @Autowired
    private IUserService userService;
 
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/word")
    @ResponseBody
    public List<WordDto> getUserWords(
            @PathVariable("page") int page,
            @PathVariable("size") int size, 
            @PathVariable("sortDir") String sortDir, 
            @PathVariable("sort") String sort) {
        
        List<Word> words = wordService.getUserWordsList(page, size, sortDir, sort);
        return words.stream()
          .map(this::convertToDto)
          .collect(Collectors.toList());
    }

    // DTO 변환
    private WordDto convertToDto(Word word) {
    	WordDto wordDto = modelMapper.map(word, WordDto.class);
        wordDto.setWrittenDate(word.getWrittenDate(), 
            userService.getCurrentUser().getPreference().getTimezone());
        return wordDto;
    }
    
    // Entity 변환
    private Word convertToEntity(WordDto wordDto) throws ParseException {
    	Word word = modelMapper.map(wordDto, Word.class);
        word.setWrittenDate(wordDto.getWrittenDateConverted(
          userService.getCurrentUser().getPreference().getTimezone()));
      
        if (wordDto.getWord_id() != null) {
        	Word oldWord = wordService.getWordById(wordDto.getWord_id());
            word.setWriter_id(oldWord.getWriter_id());
            word.setSent(oldWord.isSent());
        }
        return word;
    }
}
