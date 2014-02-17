package com.haotiben.feedback.biz;

import com.haotiben.feedback.json.SchoolStages;

public interface SchoolStageBiz {
	/**
	 * 获取学段信息
	 * @return
	 * @throws Exception
	 */
	public SchoolStages getSchoolStage()throws Exception;
}
