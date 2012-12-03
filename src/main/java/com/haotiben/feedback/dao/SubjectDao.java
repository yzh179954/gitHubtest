package com.haotiben.feedback.dao;

import java.util.List;

import com.haotiben.feedback.model.Subject;

public interface SubjectDao {
	/**
	 * 获取基础数据学科的列表
	 * @return
	 * @throws Exception
	 */
	public List<Subject> getSubjectList()throws Exception;
}
