package com.haotiben.feedback.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.haotiben.feedback.model.Knowledge;
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

}
