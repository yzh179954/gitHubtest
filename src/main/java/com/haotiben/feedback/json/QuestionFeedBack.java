package com.haotiben.feedback.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.haotiben.feedback.model.QuestionAnalysisAnswer;
import com.haotiben.feedback.model.QuestionRemark;
/**
 *  单题反馈详情
 * @author davi.shi
 *
 */
public class QuestionFeedBack implements Serializable {

	private static final long serialVersionUID = 1L;
	public QuestionJson question = new QuestionJson();
	public QuestionRemark remark = new QuestionRemark();
	public StudentJson student = new StudentJson();
	public TeacherJson teacher = new TeacherJson();
	public List<QuestionAnalysisAnswer> analysises = new ArrayList<QuestionAnalysisAnswer>();
	public List<QuestionKnowledge> knowledges = new ArrayList<QuestionKnowledge>();
	public QuestionFeedBack() {
		super();
	}
	public QuestionJson getQuestion() {
		return question;
	}
	public void setQuestion(QuestionJson question) {
		this.question = question;
	}
	public QuestionRemark getRemark() {
		return remark;
	}
	public void setRemark(QuestionRemark remark) {
		this.remark = remark;
	}
	public StudentJson getStudent() {
		return student;
	}
	public void setStudent(StudentJson student) {
		this.student = student;
	}
	public TeacherJson getTeacher() {
		return teacher;
	}
	public void setTeacher(TeacherJson teacher) {
		this.teacher = teacher;
	}
	public List<QuestionAnalysisAnswer> getAnalysises() {
		return analysises;
	}
	public void setAnalysises(List<QuestionAnalysisAnswer> analysises) {
		this.analysises = analysises;
	}
	public List<QuestionKnowledge> getKnowledges() {
		return knowledges;
	}
	public void setKnowledges(List<QuestionKnowledge> knowledges) {
		this.knowledges = knowledges;
	}

}
