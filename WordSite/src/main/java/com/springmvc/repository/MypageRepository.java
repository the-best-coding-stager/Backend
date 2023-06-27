package com.springmvc.repository;

import com.springmvc.domain.Mypage;

public interface MypageRepository {
	Mypage create(Mypage mypage);
	Mypage read(String mypageId);
	void upadte(String mypageId, Mypage mypage);
	void delete(String mypageId);
}
