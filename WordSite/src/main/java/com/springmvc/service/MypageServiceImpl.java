package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Mypage;
import com.springmvc.repository.MypageRepository;
import com.springmvc.exception.MypageException;

@Service
public class MypageServiceImpl implements MypageService {
	
	@Autowired
	private MypageRepository mypageRepository;

	@Override
	public Mypage create(Mypage mypage) {
		return mypageRepository.create(mypage);
	}

	@Override
	public Mypage read(String mypageId) {
		return mypageRepository.read(mypageId);
	}

	@Override
	public void update(String mypageId, Mypage mypage) {
		mypageRepository.upadte(mypageId, mypage);
		
	}

	@Override
	public void delete(String mypageId) {
		mypageRepository.delete(mypageId);
	}

	@Override
	public Mypage validateMypage(String mypageId) {
		Mypage mypage = mypageRepository.read(mypageId);
		if (mypage == null || mypage.getMypageItems().size() == 0) {
			throw new MypageException(mypageId);
		}
		
		return mypage;
	}

}
