package com.springmvc.domain;

import java.io.Serializable;

public class MypageItem implements Serializable {
	
	private Word word;
	private int quantity;
	private static final long serialVersionUID = 3636831123198280235L;
	
	public MypageItem() {
		
	}
	
	public MypageItem(Word word) {
		super();
		this.word = word;
		this.quantity = 1;
	}
	
	public Word getWord() {
		return word;
	}
	
	public void setWord(Word word) {
		this.word = word;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
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
		MypageItem other = (MypageItem) obj;
		if (word == null) {
			if (other.word != null)
				return false;	
		} else if (!word.equals(other.word))
			return false;
		return true;
	}
	
}
