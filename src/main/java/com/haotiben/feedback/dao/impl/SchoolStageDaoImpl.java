package com.haotiben.feedback.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.haotiben.feedback.dao.SchoolStageDao;
import com.haotiben.feedback.model.SchoolStage;

public class SchoolStageDaoImpl extends BaseDaoImpl implements SchoolStageDao {
	private static Logger log = Logger.getLogger(SchoolStageDaoImpl.class);
	private ResultSet rs = null;
	private PreparedStatement pstat = null;
	private Connection conn = null;

	@Override
	public List<SchoolStage> getSchoolStageList() throws Exception {
		List<SchoolStage> schoolStageList = new ArrayList<SchoolStage>();
		String sql = "select * from basedata_school_stage where IS_DEL = ?";
		try {
			conn = getConnection();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, 1);
			log.info(pstat.toString());
			rs = pstat.executeQuery();
			while(rs.next()){
				SchoolStage ss = new SchoolStage();
				ss.setCode(rs.getString("CODE"));
				ss.setName(rs.getString("NAME"));
				schoolStageList.add(ss);
			}
		} catch (Exception e) {
			log.error("查询SchoolStage出现异常......", e);
			throw e;
		}finally{
			try {
				if (pstat != null)
					pstat.close();
				if (rs != null)
					rs.close();
			} catch (Exception ex) {
				log.error("查询Question关闭RS或者PS出现异常......", ex);
				throw ex;
			}
		}
		return schoolStageList;
	}
}
