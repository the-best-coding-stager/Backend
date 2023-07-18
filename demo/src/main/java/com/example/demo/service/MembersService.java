package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Member;

public interface MembersService {
	List<Member> testMember();
	List<Member> getAllMembers();
	Member getMember(Integer id);
	void insertMember(Member member);
	Member updateMember(Integer id, Member member);
	Integer deleteMember(Integer id);
}
