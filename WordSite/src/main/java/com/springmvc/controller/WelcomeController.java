package com.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	
	public String welcome(Model model) {
		model.addAttribute("greeting", "Welcome to Slang");
		model.addAttribute("strapline", "Search Your Slangs!");
		return "welcome";
	}

}
