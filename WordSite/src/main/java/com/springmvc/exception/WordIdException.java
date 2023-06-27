package com.springmvc.exception;

@SuppressWarnings("serial")
public class WordIdException extends RuntimeException {
	
	private String wordId;
	
	public WordIdException(String wordId) {
		this.wordId = wordId;
	}

	public String getWordId() {
		return wordId;
	}
}
