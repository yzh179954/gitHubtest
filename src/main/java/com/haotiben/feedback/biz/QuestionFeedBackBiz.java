package com.haotiben.feedback.biz;

import com.haotiben.feedback.json.QuestionFeedBack;

public interface QuestionFeedBackBiz {
	/**
	 * 获取单题反馈信息
	 * @param questionId
	 * @return
	 * @throws Exception
	 */
	public QuestionFeedBack getSingleQuestionFeedBack(String questionId)throws Exception;
}
