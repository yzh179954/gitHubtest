package com.haotiben.feedback.biz;

import com.haotiben.feedback.json.Subjects;

public interface SubjectBiz {
	/**
	 * 获取基础数据学科
	 * @return
	 * @throws Exception
	 */
	public Subjects getSubjects()throws Exception;
}
