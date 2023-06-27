package com.springmvc.repository;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Mypage;

@Repository
public class MypageRepositoryImpl implements MypageRepository {
	
	private Map<String, Mypage> listOfMypages;
	
	public MypageRepositoryImpl() {
		listOfMypages = new HashMap<String, Mypage>();
	}

	@Override
	public Mypage create(Mypage mypage) {
		if (listOfMypages.keySet().contains(mypage.getMypageId())) {
			throw new IllegalArgumentException(String.format("장바구니를 생성할 수 없습니다. 장바구니 id(%)가 존재하지 않습니다", mypage.getMypageId()));
		}
		
		listOfMypages.put(mypage.getMypageId(), mypage);
		return mypage;
	}

	@Override
	public Mypage read(String mypageId) {
		return listOfMypages.get(mypageId);
	}

	@Override
	public void upadte(String mypageId, Mypage mypage) {
		if (!listOfMypages.keySet().contains(mypageId)) {
			throw new IllegalArgumentException(String.format("장바구니 목록을 갱신할 수 없습니다. 장바구니 id(%)가 존재하지 않습니다", mypageId));
		}
		listOfMypages.put(mypageId, mypage);
	}

	@Override
	public void delete(String mypageId) {
		if (!listOfMypages.keySet().contains(mypageId)) {
			throw new IllegalArgumentException(String.format("장바구니 목록을 삭제할 수 없습니다. 장바구니 id(%)가 존재하지 않습니다", mypageId));
		}
		listOfMypages.remove(mypageId);
	}

}
