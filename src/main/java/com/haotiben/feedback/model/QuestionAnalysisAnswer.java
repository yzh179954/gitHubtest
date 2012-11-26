package com.haotiben.feedback.model;

import java.io.Serializable;
import java.util.Date;

public class QuestionAnalysisAnswer implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private long questionId;
	private String answer;
	private int answerNo;
	private String analysisDesc;
	private String analysisUrl;
	private String answerDesc;
	private String answerUrl;
	private String teacherUserName;
	private Date createAt;
	public QuestionAnalysisAnswer() {
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
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getAnswerNo() {
		return answerNo;
	}
	public void setAnswerNo(int answerNo) {
		this.answerNo = answerNo;
	}
	public String getAnalysisDesc() {
		return analysisDesc;
	}
	public void setAnalysisDesc(String analysisDesc) {
		this.analysisDesc = analysisDesc;
	}
	public String getAnalysisUrl() {
		return analysisUrl;
	}
	public void setAnalysisUrl(String analysisUrl) {
		this.analysisUrl = analysisUrl;
	}
	public String getAnswerDesc() {
		return answerDesc;
	}
	public void setAnswerDesc(String answerDesc) {
		this.answerDesc = answerDesc;
	}
	public String getAnswerUrl() {
		return answerUrl;
	}
	public void setAnswerUrl(String answerUrl) {
		this.answerUrl = answerUrl;
	}
	public String getTeacherUserName() {
		return teacherUserName;
	}
	public void setTeacherUserName(String teacherUserName) {
		this.teacherUserName = teacherUserName;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

}
