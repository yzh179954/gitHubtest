package com.haotiben.feedback.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.haotiben.feedback.VO.Page;
import com.haotiben.feedback.dao.QuestionDao;
import com.haotiben.feedback.model.Question;
import com.haotiben.feedback.model.Remark;

public class QuestionDaoImpl extends BaseDaoImpl implements QuestionDao {
	private static Logger log = Logger.getLogger(QuestionDaoImpl.class);
	private ResultSet rs = null;
	private PreparedStatement pstat = null;
	private Connection conn = null;

	@Override
	public Question getQuestionById(long id) throws Exception {
		log.info("getQuestionById  id:"+id);
		Question question = null;
		String sql = "select * from QUESTION where ID = ?";
		try {
			conn = getConnection();
			pstat = conn.prepareStatement(sql);
			pstat.setLong(1, id);
			log.info(pstat.toString());
			rs = pstat.executeQuery();
			while(rs.next()){
				question = new Question();
				question.setBookCode(rs.getString("BOOK_CODE"));
				question.setChapterCode(rs.getString("CHAPTER_CODE"));
				question.setClientAt(rs.getTimestamp("CLIENT_AT"));
				question.setCompleteAt(rs.getTimestamp("COMPLETE_AT"));
				question.setCreateAt(rs.getTimestamp("CREATE_AT"));
				question.setGradeCode(rs.getString("GRADE_CODE"));
				question.setHelp(rs.getString("HELP"));
				question.setId(rs.getLong("ID"));
				question.setImageUrl(rs.getString("IMAGE_URL"));
				//question.setIsDel(rs.getInt("IS_DEL"));
				question.setPartCode(rs.getString("PART_CODE"));
				question.setQuestionDesc(rs.getString("QUESTION_DESC"));
				question.setSchoolStageCode(rs.getString("SCHOOL_STAGE_CODE"));
				question.setStatus(rs.getString("STATUS"));
				question.setStudentUserName(rs.getString("STUDENT_USERNAME"));
				question.setSubjectCode(rs.getString("SUBJECT_CODE"));
				question.setTeacherMobile(rs.getString("TEACH_MOBILE"));
				question.setVoiceStatus(rs.getString("VOICE_STATUS"));
			}
		} catch (Exception e) {
			log.error("查询Question出现异常......", e);
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
		return question;
	}

	@Override
	public List<Question> getQuestionAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> getQuestions(Map<String, String> map)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Remark> getPageRemarks(String sql) throws Exception {
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
//				remark.remark = rs.getString("remark");
//				remark.remarkTime = rs.getTimestamp("remarkTime");
//				remark.remarkType = rs.getInt("remarkType");
				remark.studentUserName = rs.getString("studentUserName");
				remark.teacherUserName = rs.getString("teacherUserName");
				remark.questionResolveTime = rs.getTimestamp("questionResolveTime");
				remark.questionUpTime = rs.getTimestamp("questionUpTime");
				remark.questionFetchTime=rs.getTimestamp("questionFetchTime");
				remark.subject = rs.getString("subject");
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
	public Page getPage(String sql, int pageCount, int pageSize)
			throws Exception {
		int totalRow = 0;
		Page page = null;
		try {
			conn = getConnection();
			pstat = conn.prepareStatement(sql);
			log.info(pstat.toString());
			rs = pstat.executeQuery();
			while (rs.next()) {
				totalRow = rs.getInt(1);
			}
			page = new Page(totalRow, pageCount, pageSize);
		} catch (Exception e) {
			log.error("查询Question出现异常......", e);
			throw e;
		} finally {
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
		return page;
	}

}
