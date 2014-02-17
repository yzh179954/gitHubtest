package com.haotiben.feedback.biz.impl;

import com.haotiben.feedback.biz.BaseInfoBiz;
import com.haotiben.feedback.biz.BizFactory;
import com.haotiben.feedback.biz.QuestionAnalysisAnswerBiz;
import com.haotiben.feedback.biz.QuestionBiz;
import com.haotiben.feedback.biz.QuestionFeedBackBiz;
import com.haotiben.feedback.biz.QuestionKnowledgeBiz;
import com.haotiben.feedback.biz.RemarkBiz;
import com.haotiben.feedback.biz.SchoolStageBiz;
import com.haotiben.feedback.biz.SubjectBiz;

public class BizFactoryImpl extends BizFactory {

	public BizFactoryImpl() {
		super();
	}

	@Override
	public RemarkBiz getRemarkBiz() throws Exception {
		return new RemarkBizImpl();
	}

	@Override
	public QuestionBiz getQuestionBiz() throws Exception {
		return new QuestionBizImpl();
	}

	@Override
	public QuestionAnalysisAnswerBiz getQuestionAnalysisAnswerBiz()
			throws Exception {
		return new QuestionAnalysisAnswerBizImpl();
	}

	@Override
	public QuestionFeedBackBiz getQuestionFeedBackBiz() throws Exception {
		return new QuestionFeedBackBizImpl();
	}

	@Override
	public SubjectBiz getSubjectBiz() throws Exception {
		return new SubjectBizImpl();
	}

	@Override
	public SchoolStageBiz getSchoolStageBiz() throws Exception {
		return new SchoolStageBizImpl();
	}

	@Override
	public BaseInfoBiz getBaseInfoBiz() throws Exception {
		return new BaseInfoBizImpl();
	}

	@Override
	public QuestionKnowledgeBiz getQuestionKnowledgeBiz() throws Exception {
		return new QuestionKnowledgeBizImpl();
	}

}
