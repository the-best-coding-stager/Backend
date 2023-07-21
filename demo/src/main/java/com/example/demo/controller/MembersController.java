package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Member;
import com.example.demo.service.MembersService;

@RestController
@RequestMapping("/members")
public class MembersController {
	
	@Autowired
	private MembersService service;
	
	@GetMapping
	public List<Member> getAllMembers() {
		return service.getAllMembers();
	}
	
	@GetMapping(path="/{id}")
	public Member getMember(@PathVariable Integer id) {
		return service.getMember(id);
	}
	
	@PostMapping
	public Member insertMember(@RequestBody Member member) {
		service.insertMember(member);
		return member;
	}
	
	@PutMapping(path="/{id}")
	public Member updateMember(@PathVariable Integer id, @RequestBody Member member) {
		return service.updateMember(id, member);
	}
	
	@DeleteMapping(path="/{id}")
	public Integer deleteMember(@PathVariable Integer id) {
		return service.deleteMember(id);
	}
	
}
