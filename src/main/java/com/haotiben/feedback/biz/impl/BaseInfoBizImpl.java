package com.haotiben.feedback.biz.impl;

import org.apache.log4j.Logger;

import com.haotiben.feedback.biz.BaseInfoBiz;
import com.haotiben.feedback.dao.BaseInfoDao;
import com.haotiben.feedback.dao.DaoFactory;

public class BaseInfoBizImpl implements BaseInfoBiz {
	private static Logger log = Logger.getLogger(BaseInfoBizImpl.class);
	private DaoFactory factory = null;
	private BaseInfoDao bDao = null;
	@Override
	public String getBaseInfo(String table,String code) throws Exception {
		String name = "";
		String sql = "";
		try {
			factory = DaoFactory.newInstance();
			factory.beginTransaction();
			bDao = factory.getBaseInfoDao();
			sql = getBaseInfoSql(table, code);
			name = bDao.getBaseInfo(sql);
			log.info("getBaseInfo  name = "+name);
			factory.commit();
		}  catch (Exception e) {
			log.error("方法  getBaseInfoByCode 出现异常......", e);
			factory.rollBack();
			throw e;
		} finally {
			try {
				factory.release();
				log.info("Connection is closed......");
			} catch (Exception e2) {
				log.error("Connection closeing error....", e2);
			}
		}
		return name;
	}
	/**
	 * 获取查询基础数据SQL语句
	 * @param table 要查询的表名称
	 * @param code 查询的条件
	 * @return
	 * @throws Exception
	 */
	public String getBaseInfoSql(String table,String code) throws Exception{
		String sql = "";
		try {
			sql = "select NAME from BASEDATA_"+table+" where CODE = '"+code+"'";
			log.info("getBaseInfoSql sql = "+sql);
		} catch (Exception e) {
			log.error("",e);
		}
		return sql;
	}
	public static void main(String[] args) {
		BaseInfoBizImpl b = new BaseInfoBizImpl();
		try {
			b.getBaseInfo("subject", "HUAXUE");
			b.getBaseInfo("school_stage", "CHUZHONG");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
