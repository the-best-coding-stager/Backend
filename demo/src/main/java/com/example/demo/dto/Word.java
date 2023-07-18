package com.example.demo.dto;

public class Word {
	
	private Integer word_id;
	private String name;
	private String title;
	private String description;
	private String writer_id;

	public Word() {
		super();
	}

	public Integer getWord_Id() {
		return word_id;
	}

	public void setWord_Id(Integer word_id) {
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
	
	@Override
	public String toString() {
		return "Word [id=" + word_id + ", name=" + name + ", title=" + title + ", description=" + description + ", writer_id=" + writer_id + "]";
	}

}
