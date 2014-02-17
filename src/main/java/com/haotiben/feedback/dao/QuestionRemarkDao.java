package com.haotiben.feedback.dao;

import java.util.List;
import java.util.Map;

import com.haotiben.feedback.VO.TeacherTop;
import com.haotiben.feedback.model.QuestionRemark;

public interface QuestionRemarkDao {
	/**
	 * 根据主键ID查询反馈信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public QuestionRemark getQuestionRemarkById(long id) throws Exception;
	/**
	 * 根据试题ID查询反馈信息
	 * @param questionId
	 * @return
	 * @throws Exception
	 */
	public List<QuestionRemark> getQuestionRemarkByQuestionId(long questionId) throws Exception;
	/**
	 * 查询所有反馈信息
	 * @return
	 * @throws Exception
	 */
	public List<QuestionRemark> getQuestionRemarkAll() throws Exception;
	/**
	 * 根据Map动态条件查询反馈信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<QuestionRemark> getQuestionRemarks(Map<String,String> map) throws Exception;

}
