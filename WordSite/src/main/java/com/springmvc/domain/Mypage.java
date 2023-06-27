package com.springmvc.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Mypage implements Serializable {
	
	private String mypageId;
	private Map<String, MypageItem> mypageItems;
	private static final long serialVersionUID = 2155125089108199199L;
	
	public Mypage() {
		mypageItems = new HashMap<String, MypageItem>();
	}

	public Mypage(String mypageId) {
		this();
		this.mypageId = mypageId;
	}

	public String getMypageId() {
		return mypageId;
	}

	public void setMypageId(String mypageId) {
		this.mypageId = mypageId;
	}

	public Map<String, MypageItem> getMypageItems() {
		return mypageItems;
	}

	public void setMypageItems(Map<String, MypageItem> mypageItems) {
		this.mypageItems = mypageItems;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mypageId == null) ? 0 : mypageId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mypage other = (Mypage) obj;
		if (mypageId == null) {
			if (other.mypageId != null)
				return false;	
		} else if (!mypageId.equals(other.mypageId))
			return false;
		return true;
	}
	
	public void addMypageItem(MypageItem item) {
		String wordId = item.getWord().getWordId();
		
		if (mypageItems.containsKey(wordId)) {
			MypageItem mypageItem = mypageItems.get(wordId);
			mypageItem.setQuantity(mypageItem.getQuantity() + item.getQuantity());
			mypageItems.put(wordId, mypageItem);				
		} else {
			mypageItems.put(wordId, item);
		}
	}
	
	public void removeMypageItem(MypageItem item) {
		String wordId = item.getWord().getWordId();
		mypageItems.remove(wordId);
	}

}
