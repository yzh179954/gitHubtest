package com.haotiben.feedback.json;

import java.io.Serializable;

public class QuestionKnowledge implements Serializable {
	private static final long serialVersionUID = 1L;
	public long questionId;
	public String code;
	public String name;
	public QuestionKnowledge() {
		super();
	}
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
