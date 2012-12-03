package com.haotiben.feedback.biz;

import com.haotiben.feedback.biz.impl.BizFactoryImpl;

public abstract class BizFactory {

	protected BizFactory() {
		super();
	}

	/**
	 * Create a factory instance
	 *
	 * @return
	 */
	public static BizFactory newInstance() throws Exception {
		return new BizFactoryImpl();
	}

	public abstract RemarkBiz getRemarkBiz() throws Exception;

	public abstract QuestionBiz getQuestionBiz() throws Exception;

	public abstract QuestionAnalysisAnswerBiz getQuestionAnalysisAnswerBiz()
			throws Exception;

	public abstract QuestionFeedBackBiz getQuestionFeedBackBiz()
			throws Exception;

	public abstract SubjectBiz getSubjectBiz() throws Exception;

	public abstract SchoolStageBiz getSchoolStageBiz() throws Exception;

	public abstract BaseInfoBiz getBaseInfoBiz() throws Exception;

	public abstract QuestionKnowledgeBiz getQuestionKnowledgeBiz()
			throws Exception;
}