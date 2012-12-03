package com.haotiben.feedback.dao;

import java.util.List;

import com.haotiben.feedback.VO.Page;
import com.haotiben.feedback.model.QuestionRemark;
import com.haotiben.feedback.model.Remark;

public interface RemarkDao {
	/**
	 * 该DAO接口用于查询反馈信息记录,封装了分页
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
	 * 根据试题编号查询该题的反馈信息
	 * @param questionId
	 * @return
	 * @throws Exception
	 */
	public QuestionRemark getRemark(long questionId) throws Exception;
}
