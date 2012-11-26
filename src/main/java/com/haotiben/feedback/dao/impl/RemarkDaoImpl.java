package com.haotiben.feedback.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.haotiben.feedback.VO.Page;
import com.haotiben.feedback.dao.RemarkDao;
import com.haotiben.feedback.model.Remark;

public class RemarkDaoImpl extends BaseDaoImpl implements RemarkDao {
	private static Logger log = Logger.getLogger(RemarkDaoImpl.class);
	private ResultSet rs = null;
	private PreparedStatement pstat = null;
	private Connection conn = null;

	@Override
	public List<Remark> getPageRemarks(String sql, Page page) throws Exception {
		List<Remark> remarks = new ArrayList<Remark>();
		try {
			conn = getConnection();
			pstat = conn.prepareStatement(sql);
			log.info(pstat.toString());
			rs = pstat.executeQuery();
			while (rs.next()) {
				Remark remark = new Remark();
				remark.imageUrl = rs.getString("imageUrl");
				remark.questionId = rs.getLong("questionId");
				remark.remark = rs.getString("remark");
				remark.remarkTime = rs.getTimestamp("remarkTime");
				remark.remarkType = rs.getInt("remarkType");
				remark.studentUserName = rs.getString("studentUserName");
				remark.teacherUserName = rs.getString("teacherUserName");
				remarks.add(remark);
			}
		} catch (Exception e) {
			log.error("查询Remark出现异常......", e);
			throw e;
		} finally {
			try {
				if (pstat != null)
					pstat.close();
				if (rs != null)
					rs.close();
			} catch (Exception ex) {
				log.error("查询Remark关闭RS或者PS出现异常......", ex);
				throw ex;
			}
		}
		return remarks;
	}

	@Override
	public Page getPage(String sql, int pageCount) throws Exception {
		int totalRow = 0;
		Page page = null;
		try {
			conn = getConnection();
			pstat = conn.prepareStatement(sql);
			log.info(pstat.toString());
			rs = pstat.executeQuery();
			while (rs.next()) {
				totalRow = rs.getInt(0);
			}
			page = new Page(totalRow, pageCount);
		} catch (Exception e) {
			log.error("查询Remark出现异常......", e);
			throw e;
		} finally {
			try {
				if (pstat != null)
					pstat.close();
				if (rs != null)
					rs.close();
			} catch (Exception ex) {
				log.error("查询Remark关闭RS或者PS出现异常......", ex);
				throw ex;
			}
		}
		return page;
	}

}
