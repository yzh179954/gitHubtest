package com.haotiben.feedback.biz;

import java.util.List;

import com.haotiben.feedback.json.QuestionKnowledge;

public interface QuestionKnowledgeBiz {
	/**
	 * 根据试题ID获取该题涉及的知识点列表
	 * @param questionId
	 * @return
	 * @throws Exception
	 */
	public List<QuestionKnowledge> getQuestionKnowledge(String questionId)throws Exception;
}
