package com.java.entity;

import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Result {
	int rs_id;
	
	@Id
	public int getRs_id() {
		return rs_id;
	}


	public void setRs_id(int rs_id) {
		this.rs_id = rs_id;
	}


@Temporal(TemporalType.DATE)
	Date attampDate;
boolean isAttampt;
	int userId;
	public boolean isAttampt() {
		return isAttampt;
	}


	public void setAttampt(boolean isAttampt) {
		this.isAttampt = isAttampt;
	}


	int questionId;
	int answered;
	boolean mark;
	public boolean isCorrect() {
		return correct;
	}


	public void setMark(boolean mark) {
		this.mark = mark;
	}


	boolean correct;
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}


	int incorrect;
	int total;
	



	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getQuestionId() {
		return questionId;
	}


	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}


	public int getAnswered() {
		return answered;
	}


	public void setAnswered(int answered) {
		this.answered = answered;
	}





	

	public int getIncorrect() {
		return incorrect;
	}


	public void setIncorrect(int incorrect) {
		this.incorrect = incorrect;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public Date getAttampDate() {
		return attampDate;
	}


	public void setAttampDate(Date attampDate) {
		this.attampDate = attampDate;
	}


	

}
