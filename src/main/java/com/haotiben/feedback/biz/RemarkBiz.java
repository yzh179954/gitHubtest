package com.haotiben.feedback.biz;

import com.haotiben.feedback.json.FeedBack;

public interface RemarkBiz {
	/**
	 * 获取反馈信息
	 * @param json JSON格式参数转化的字符串
	 * @return
	 * @throws Exception
	 */
	public FeedBack getFeedBack(String json)throws Exception;
}
