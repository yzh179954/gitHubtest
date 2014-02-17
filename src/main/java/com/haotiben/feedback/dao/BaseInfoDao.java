package com.haotiben.feedback.dao;

public interface BaseInfoDao {
	/**
	 * 查询基础数据信息的公共DAO
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public String getBaseInfo (String sql) throws Exception;
}
