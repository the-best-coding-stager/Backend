package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Member;

@Repository
public interface MembersDAO {
	List<Member> getAllMembers();
	Member getMember(Integer id);
	void insertMember(Member member);
	Integer updateMember(@Param("id") Integer id, @Param("member") Member member);
	Integer deleteMember(Integer id);
}
