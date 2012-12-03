package com.haotiben.feedback.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.haotiben.feedback.dao.SubjectDao;
import com.haotiben.feedback.model.Subject;

public class SubjectDaoImpl extends BaseDaoImpl implements SubjectDao {
	private static Logger log = Logger.getLogger(SchoolStageDaoImpl.class);
	private ResultSet rs = null;
	private PreparedStatement pstat = null;
	private Connection conn = null;
	@Override
	public List<Subject> getSubjectList() throws Exception {
		List<Subject> subjectList = new ArrayList<Subject>();
		String sql = "select * from basedata_subject where IS_DEL = ?";
		try {
			conn = getConnection();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, 1);
			log.info(pstat.toString());
			rs = pstat.executeQuery();
			while(rs.next()){
				Subject subject = new Subject();
				subject.setCode(rs.getString("CODE"));
				subject.setName(rs.getString("NAME"));
				subjectList.add(subject);
			}
		} catch (Exception e) {
			log.error("查询Subject出现异常......", e);
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
		return subjectList;
	}

}
