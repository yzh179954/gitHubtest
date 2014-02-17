package com.haotiben.feedback.dao;

import java.util.List;
import java.util.Map;

import com.haotiben.feedback.model.QuestionAnalysisAnswer;

public interface QuestionAnalysisAnswerDao {
	/**
	 * 根据ID获取解析解答信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public QuestionAnalysisAnswer getQuestionAnalysisAnswerById(long id) throws Exception;
	/**
	 * 根据试题ID获取该题下的所有解析解答
	 * @param questionId
	 * @return
	 * @throws Exception
	 */
	public List<QuestionAnalysisAnswer> getQuestionAnalysisAnswerByQuestionId(long questionId) throws Exception;
	/**
	 * 获取所有解析解答
	 * @return
	 * @throws Exception
	 */
	public List<QuestionAnalysisAnswer> getQuestionAnalysisAnswerAll() throws Exception;
	/**
	 * 根据动态Map里的条件来查询解析解答信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<QuestionAnalysisAnswer> getQuestionAnalysisAnswers(Map<String,String> map) throws Exception;
}
