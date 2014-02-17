package com.haotiben.feedback.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.haotiben.feedback.dao.BaseInfoDao;

public class BaseInfoDaoImpl extends BaseDaoImpl implements BaseInfoDao {
	private static Logger log = Logger.getLogger(QuestionDaoImpl.class);
	private ResultSet rs = null;
	private PreparedStatement pstat = null;
	private Connection conn = null;
	@Override
	public String getBaseInfo(String sql) throws Exception {
		String returnValue = "";
		try {
			conn = getConnection();
			pstat = conn.prepareStatement(sql);
			log.info(pstat.toString());
			rs = pstat.executeQuery();
			while(rs.next()){
				returnValue = rs.getString(1);
			}
		}  catch (Exception e) {
			log.error("查询基础数据出现异常......", e);
			throw e;
		}finally{
			try {
				if (pstat != null)
					pstat.close();
				if (rs != null)
					rs.close();
			} catch (Exception ex) {
				log.error("查询基础数据关闭RS或者PS出现异常......", ex);
				throw ex;
			}
		}
		return returnValue;
	}

}
