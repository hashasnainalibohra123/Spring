package com.java.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Questions {
	@Id
	int id;
	String question;
	String optiona1;
	String optiona2;
	String optiona3;
	String optiona4;
	String answer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOptiona1() {
		return optiona1;
	}
	public void setOptiona1(String optiona1) {
		this.optiona1 = optiona1;
	}
	public String getOptiona2() {
		return optiona2;
	}
	public void setOptiona2(String optiona2) {
		this.optiona2 = optiona2;
	}
	public String getOptiona3() {
		return optiona3;
	}
	public void setOptiona3(String optiona3) {
		this.optiona3 = optiona3;
	}
	public String getOptiona4() {
		return optiona4;
	}
	public void setOptiona4(String optiona4) {
		this.optiona4 = optiona4;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
