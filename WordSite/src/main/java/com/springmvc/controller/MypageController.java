package com.springmvc.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.domain.Word;
import com.springmvc.domain.Mypage;
import com.springmvc.domain.MypageItem;
import com.springmvc.service.WordService;
import com.springmvc.service.MypageService;
import com.springmvc.exception.WordIdException;

@Controller
@RequestMapping(value="/mypage")
public class MypageController {

	@Autowired
	private MypageService mypageService;
	
	@Autowired
	private WordService wordService;
	
	@GetMapping
	public String requestMypageId(HttpServletRequest request) {
		String sessionid = request.getSession(true).getId();
		return "redirect:/mypage/" + sessionid;
	}
	
	@PostMapping
	public @ResponseBody Mypage create(@RequestBody Mypage mypage) {
		return mypageService.create(mypage);
	}
	
	@GetMapping("/{mypageId}")
	public String requestCartList(@PathVariable(value="mypageId") String mypageId, Model model) {
		Mypage mypage = mypageService.read(mypageId);
		model.addAttribute("mypage", mypage);
		return "mypage";
	}
	
	@PutMapping("/{mypageId}")
	public @ResponseBody Mypage read(@PathVariable(value="mypageId") String mypageId) {
		return mypageService.read(mypageId);
	}
	
	@PutMapping("/add/{wordId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void addCartByNewItem(@PathVariable String wordId, HttpServletRequest request) {
		String sessionId = request.getSession(true).getId();
		Mypage mypage = mypageService.read(sessionId);
		if (mypage == null)
			mypage = mypageService.create(new Mypage(sessionId));
		Word word = wordService.getWordById(wordId);
		if (word == null)
			throw new IllegalArgumentException(new WordIdException(wordId));
		mypage.addMypageItem(new MypageItem(word));
		mypageService.update(sessionId, mypage);
	}
	
	@PutMapping("/remove/{wordId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void removeCartByItem(@PathVariable String wordId, HttpServletRequest request) {
		String sessionId = request.getSession(true).getId();
		Mypage mypage = mypageService.read(sessionId);
		if (mypage == null)
			mypage = mypageService.create(new Mypage(sessionId));
		Word word = wordService.getWordById(wordId);
		if (word == null)
			throw new IllegalArgumentException(new WordIdException(wordId));
		mypage.removeMypageItem(new MypageItem(word));
		mypageService.update(sessionId, mypage);
	}
	
	@DeleteMapping("/{mypageId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void deleteCartList(@PathVariable(value="mypageId") String mypageId) {
		mypageService.delete(mypageId);
	}
}
