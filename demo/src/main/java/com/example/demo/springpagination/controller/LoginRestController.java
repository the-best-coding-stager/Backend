package com.example.demo.springpagination.controller;

import com.example.demo.springpagination.dto.UserDto;
import com.example.demo.springpagination.model.User;
import com.example.demo.springpagination.service.IUserService;

import java.text.ParseException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class LoginRestController {
	
	@Autowired
    private IUserService userService;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@PostMapping(path="/signup")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public UserDto createUser(@RequestBody UserDto userDto) throws ParseException {
		User user = convertToEntity(userDto);
		User userCreated = userService.createUser(user);
        return convertToDto(userCreated);
        // 여기다 단어 db에 업데이트하는 함수 추가
    }

	private UserDto convertToDto(User user) {
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return userDto;
	}

	private User convertToEntity(UserDto userDto) throws ParseException {
		User user = modelMapper.map(userDto, User.class);
		
		if (userDto.getUser_id() != null) {
			User oldUser = userService.getUserById(userDto.getId());
		}
		return user;
	}
	
}
