package com.haotiben.feedback.dao;

import java.util.List;
import java.util.Map;

import com.haotiben.feedback.model.Question;

public interface QuestionDao {
	/**
	 * 根据主键ID查询试题信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Question getQuestionById(long id) throws Exception;
	/**
	 * 查询所有试题信息
	 * @return
	 * @throws Exception
	 */
	public List<Question> getQuestionAll()throws Exception;
	/**
	 * 根据Map动态条件查询试题信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Question> getQuestions (Map<String,String> map) throws Exception;
}
