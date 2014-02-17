package com.haotiben.feedback.biz;

import java.util.List;

import com.haotiben.feedback.model.QuestionAnalysisAnswer;

public interface QuestionAnalysisAnswerBiz {
	/**
	 * 根据试题编号获取相应的解析解答
	 *
	 * @param questionId
	 * @return
	 * @throws Exception
	 */
	public List<QuestionAnalysisAnswer> getQuestionAnalysisAnswerByQuestionId(
			long questionId) throws Exception;
	/**
	 * 根据主键ID查询解析解答信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public QuestionAnalysisAnswer getQuestionAnalysisAnswerByID(String id)
			throws Exception;
}
