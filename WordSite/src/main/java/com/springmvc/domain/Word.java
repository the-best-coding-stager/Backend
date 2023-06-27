package com.springmvc.domain;

import java.io.Serializable;
import javax.validation.constraints.Size;

import com.springmvc.validator.WordId;

public class Word implements Serializable {
	@WordId
	private String wordId;
	
	@Size(min=1, max=50, message="{Size.NewWord.name}")
	private String name;
	
	@Size(min=0, max=255, message="{Size.NewWord.title}")
	private String title;

	private String description;
	
	private String writer;
	
	private String releaseDate;

	private static final long serialVersionUID = -7715651009026349175L;
	
	public Word() {
		super();	
	}

	public Word(String wordId, String name) {
		super();
		this.wordId = wordId;
		this.name = name;
	}

	public String getWordId() {
		return wordId;
	}

	public void setWordId(String wordId) {
		this.wordId = wordId;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

}
