package com.springmvc.service;

import com.springmvc.domain.Mypage;

public interface MypageService {
	Mypage create(Mypage mypage);
	Mypage read(String mypageId);
	void update(String mypageId, Mypage mypage);
	void delete(String mypageId);
	Mypage validateMypage(String mypageId);
}
