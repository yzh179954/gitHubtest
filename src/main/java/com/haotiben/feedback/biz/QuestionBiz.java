package com.haotiben.feedback.biz;

import com.haotiben.feedback.json.FeedBack;
import com.haotiben.feedback.model.Question;

public interface QuestionBiz {
	/**
	 * 根据试题ID获取试题详细信息
	 * @param questionId
	 * @return
	 * @throws Exception
	 */
	public Question getQuestion(long questionId) throws Exception;
	/**
	 * 获取试题信息   返回分页的数据信息
	 * @param json JSON格式参数转化的字符串
	 * @return
	 * @throws Exception
	 */
	public FeedBack getQuestion(String json)throws Exception;
	/**
	 * 获取试题信息   返回一个不分页的信息
	 * @param json JSON格式参数转化的字符串
	 * @return
	 * @throws Exception
	 */
	public FeedBack getQuestionExecl(String json) throws Exception;

}
