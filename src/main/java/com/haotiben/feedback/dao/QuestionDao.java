package com.haotiben.feedback.dao;

import java.util.List;
import java.util.Map;

import com.haotiben.feedback.VO.Page;
import com.haotiben.feedback.model.Question;
import com.haotiben.feedback.model.Remark;

public interface QuestionDao {
	/**
	 * 根据主键ID查询试题信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Question getQuestionById(long id) throws Exception;

	/**
	 * 该DAO接口用于查询试题信息记录,封装了分页
	 *
	 * @param sql
	 *            查询SQL语句
	 * @param page
	 *            （封装的分页对象）
	 * @return
	 * @throws Exception
	 */
	public List<Remark> getPageRemarks(String sql) throws Exception;

	/**
	 * 获取总记录数的分页对象
	 *
	 * @param sql
	 * @param pageCount
	 * @return
	 * @throws Exception
	 */
	public Page getPage(String sql, int pageCount,int pageSize) throws Exception;

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
