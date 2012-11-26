package com.haotiben.feedback.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.haotiben.feedback.model.Question;
import com.haotiben.feedback.model.QuestionAnalysisAnswer;
/**
 *  单题反馈详情
 * @author davi.shi
 *
 */
public class QuestionFeedBack implements Serializable {

	private static final long serialVersionUID = 1L;
	public Question question;
	public Student student;
	public Teacher teacher;
	public List<QuestionAnalysisAnswer> analysises = new ArrayList<QuestionAnalysisAnswer>();
}
