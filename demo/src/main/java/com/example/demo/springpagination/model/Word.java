package com.example.demo.springpagination.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@Entity
@Table(name="words")
public class Word {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "word_id")
    private long word_id;
	
	@Column(nullable = false, name = "name")
    private String name;
	
	@Column(nullable = false, name = "description")
    private String description;
	
	@Column(nullable = true, name = "writerId")
    private String writerId;
	
	@Column(nullable = true, name = "viewcount")
    @ColumnDefault("0")
	private Long viewcount;
	
	@Column(nullable = true, name = "likes")
    @ColumnDefault("0")
	private Long likes;

	@Column(nullable = true, name = "date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date date;
	
	public Word() {
		
	}

	public Long getWord_id() {
		return word_id;
	}

	public void setWord_id(Long word_id) {
		this.word_id = word_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWriter_id() {
		return writerId;
	}

	public void setWriter_id(String writerId) {
		this.writerId = writerId;
	}

	public Long getViewcount() {
		return viewcount;
	}

	public void setViewcount(Long viewcount) {
		this.viewcount = viewcount;
	}

	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
