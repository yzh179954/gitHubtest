package com.haotiben.feedback.biz;

public interface BaseInfoBiz {
	/**
	 * 根据sql查询基础数据信息
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public String getBaseInfo(String table,String code)throws Exception;
}
