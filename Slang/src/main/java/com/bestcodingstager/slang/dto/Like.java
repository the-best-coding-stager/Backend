package com.bestcodingstager.slang.dto;

public class Like {
	
	private Integer id;
	private Integer word_id;
	private Integer user_id;

	public Like() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWord_id() {
		return word_id;
	}

	public void setWord_id(Integer word_id) {
		this.word_id = word_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	@Override
	public String toString() {
		return "Like [id=" + id + ", word_id=" + word_id + ", user_id=" + user_id + "]";
	}

}
