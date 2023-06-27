package com.springmvc.exception;

public class MypageException extends RuntimeException {
	
	private static final long serialVersionUID = -5192041563033358491L;
	private String mypageId;
	
	public MypageException(String mypageId) {
		this.mypageId = mypageId;
	}
	
	public String getMypageId() {
		return mypageId;
	}

}
