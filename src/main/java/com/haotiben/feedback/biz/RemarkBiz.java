package com.haotiben.feedback.biz;

import com.haotiben.feedback.json.FeedBack;
import com.haotiben.feedback.json.TeacherFeedBackTop;
import com.haotiben.feedback.model.QuestionRemark;

public interface RemarkBiz {
	/**
	 * 获取反馈信息
	 * @param json JSON格式参数转化的字符串
	 * @return
	 * @throws Exception
	 */
	public FeedBack getFeedBack(String json)throws Exception;
	/**
	 * 根据试题ID查询该题的反馈信息
	 * @param questionId
	 * @return
	 * @throws Exception
	 */
	public QuestionRemark getRemark(String questionId) throws Exception;
	/**
	 * 获取老师被评价不满意的TOP列表名单
	 * @return
	 * @throws Exception
	 */
	public TeacherFeedBackTop getTeacherFeedBackTop() throws Exception;
}
