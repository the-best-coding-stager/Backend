package com.example.demo.dto;

public class Word {
	
	private Integer word_id;
	private String name;
	private String title;
	private String description;
	private String writer_id;
	private Integer viewcount;
	private Integer likes;
	private String written_date;

	public Word() {
		super();
	}

	public Integer getWord_id() {
		return word_id;
	}

	public void setWord_id(Integer word_id) {
		this.word_id = word_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}

	public Integer getViewcount() {
		return viewcount;
	}

	public void setViewcount(Integer viewcount) {
		this.viewcount = viewcount;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public String getWritten_date() {
		return written_date;
	}

	public void setWritten_date(String written_date) {
		this.written_date = written_date;
	}

	@Override
	public String toString() {
		return "Word [word_id=" + word_id + ", name=" + name + ", title=" + title + ", description=" + description + ", writer_id=" + writer_id + ", viewcount=" + viewcount + ", likes=" + likes + ", written_date=" + written_date + "]";
	}

}
