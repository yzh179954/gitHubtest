package com.haotiben.feedback.dao;

import java.util.List;

import com.haotiben.feedback.json.QuestionKnowledge;

public interface QuestionKnowledgeDao {
	/**
	 * 根据试题ID获取该题涉及知识点的DAO接口
	 * @param questionId
	 * @return
	 * @throws Exception
	 */
	public List<QuestionKnowledge> getQuestionKnowledges(long questionId)throws Exception;
}
