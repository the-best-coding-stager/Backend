package com.example.demo.springpagination.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("words")
@Entity
// @Table(name="words")
public class Word {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "word_id")
    private long word_id;
	
	@Column(nullable = false, name = "name")
    private String name;
	
	@Column(name = "description")
    private String description;
	
	@Column(name = "writer_id")
    private String writer_id;
	
	@Column(name = "viewcount")
    @ColumnDefault("0")
	private Long viewcount;
	
	@Column(name = "likes")
    @ColumnDefault("0")
	private Long likes;
	
	private String date;

	@Column(name = "written_date")
	@CreatedDate
	private Date written_date;
	
	private boolean sent;
	
	public Word() {
		
	}
	
	public boolean isSent() {
        return sent;
    }
	
	public void setSent(boolean sent) {
        this.sent = sent;
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
		return writer_id;
	}

	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
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
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Date getWrittenDate() {
		return written_date;
	}

	public void setWrittenDate(Date written_date) {
		this.written_date = written_date;
	}

}
