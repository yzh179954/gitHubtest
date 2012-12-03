package com.haotiben.feedback.biz;

import com.haotiben.feedback.model.Question;

public interface QuestionBiz {
	/**
	 * 根据试题ID获取试题详细信息
	 * @param questionId
	 * @return
	 * @throws Exception
	 */
	public Question getQuestion(long questionId) throws Exception;
}
