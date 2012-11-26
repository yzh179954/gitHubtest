package com.haotiben.feedback.model;

import java.io.Serializable;
import java.util.Date;

public class QuestionRemark implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private long questionId;
	private int remarkType;
	private String remark;
	private Date createAt;
	public QuestionRemark() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	public int getRemarkType() {
		return remarkType;
	}
	public void setRemarkType(int remarkType) {
		this.remarkType = remarkType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
}
