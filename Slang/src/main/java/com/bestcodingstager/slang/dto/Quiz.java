package com.bestcodingstager.slang.dto;

public class Quiz {
	
	private Integer id;
	private String quiz_question;
	private String quiz_answer;
	
	public Quiz() {
		super();
	}
	
	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getQuiz_question() {
		return quiz_question;
	}



	public void setQuiz_question(String quiz_question) {
		this.quiz_question = quiz_question;
	}



	public String getQuiz_answer() {
		return quiz_answer;
	}



	public void setQuiz_answer(String quiz_answer) {
		this.quiz_answer = quiz_answer;
	}



	@Override
	public String toString() {
		return "Quiz [id=" + id + ", quiz_question=" + quiz_question + ", quiz_answer=" + quiz_answer + "]";
	}

}
