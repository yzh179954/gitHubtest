package com.haotiben.feedback.model;

import java.io.Serializable;

public class Knowledge implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private long questionId;
	private String code;
	public Knowledge() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

}
