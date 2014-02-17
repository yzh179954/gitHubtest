package com.haotiben.feedback.dao;

import java.util.List;

import com.haotiben.feedback.model.SchoolStage;

public interface SchoolStageDao {
	/**
	 * 获取学段基础数据
	 * @return
	 * @throws Exception
	 */
	public List<SchoolStage> getSchoolStageList()throws Exception;
}
