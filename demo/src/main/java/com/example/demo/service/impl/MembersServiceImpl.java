package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MembersDAO;
import com.example.demo.dto.Member;
import com.example.demo.service.MembersService;

@Service
public class MembersServiceImpl implements MembersService {
	
	@Autowired
	private MembersDAO dao;

	public List<Member> getAllMembers() {
		return dao.getAllMembers();
	}

	public Member getMember(Integer id) {
		return dao.getMember(id);
	}

	public void insertMember(Member member) {
		dao.insertMember(member);
	}

	public Member updateMember(Integer id, Member member) {
		Member updatedMember = new Member();
		
		if(dao.updateMember(id, member)==1) {
			updatedMember.setId(id);
			updatedMember.setName(member.getName());
			updatedMember.setAge(member.getAge());
			updatedMember.setDept(member.getDept());
		}
		return updatedMember;
	}

	public Integer deleteMember(Integer id) {
		return dao.deleteMember(id);
	}
	
}
