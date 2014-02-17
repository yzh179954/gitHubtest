package com.haotiben.feedback.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.haotiben.feedback.common.Resource;
import com.haotiben.feedback.dao.QuestionAnalysisAnswerDao;
import com.haotiben.feedback.model.QuestionAnalysisAnswer;

public class QuestionAnalysisAnswerDaoImpl extends BaseDaoImpl implements
		QuestionAnalysisAnswerDao {
	private static Logger log = Logger.getLogger(QuestionAnalysisAnswerDaoImpl.class);
	private ResultSet rs = null;
	private PreparedStatement pstat = null;
	private Connection conn = null;
	private final static String BASE_URL = Resource.getString("baseurl");
	@Override
	public QuestionAnalysisAnswer getQuestionAnalysisAnswerById(long id)
			throws Exception {
		log.info("getQuestionAnalysisAnswerById  id:"+id);
		QuestionAnalysisAnswer qaa = null;
		String sql = "select * from QUESTION_ANALYSIS_ANSWER where ID = ?";
		try {
			conn = getConnection();
			pstat = conn.prepareStatement(sql);
			pstat.setLong(1, id);
			log.info(pstat.toString());
			rs = pstat.executeQuery();
			while(rs.next()){
				qaa = new QuestionAnalysisAnswer();
				qaa.setAnalysisDesc(rs.getString("ANALYSIS_DESC"));
				qaa.setAnalysisUrl(BASE_URL+rs.getString("ANALYSIS_URL"));
				qaa.setAnswer(rs.getString("ANSWER"));
				qaa.setAnswerDesc(rs.getString("ANSWER_DESC"));
				qaa.setAnswerNo(rs.getInt("ANSWER_NO"));
				qaa.setAnswerUrl(BASE_URL+rs.getString("ANSWER_URL"));
				qaa.setCreateAt(rs.getTimestamp("CREATE_AT"));
				qaa.setId(rs.getLong("ID"));
				qaa.setQuestionId(rs.getLong("QUESTION_ID"));
				qaa.setTeacherUserName(rs.getString("TEACHER_USERNAME"));
			}
		} catch (Exception e) {
			log.error("查询QuestionAnalysisAnswer出现异常......", e);
			throw e;
		}finally{
			try {
				if (pstat != null)
					pstat.close();
				if (rs != null)
					rs.close();
			} catch (Exception ex) {
				log.error("查询QuestionAnalysisAnswer关闭RS或者PS出现异常......", ex);
				throw ex;
			}
		}
		return qaa;
	}

	@Override
	public List<QuestionAnalysisAnswer> getQuestionAnalysisAnswerByQuestionId(
			long questionId) throws Exception {
		log.info("getQuestionAnalysisAnswerById  questionId:"+questionId);
		String sql = "select * from QUESTION_ANALYSIS_ANSWER where QUESTION_ID = ?";
		List<QuestionAnalysisAnswer> analysisList = new ArrayList<QuestionAnalysisAnswer>();
		try {
			conn = getConnection();
			pstat = conn.prepareStatement(sql);
			pstat.setLong(1, questionId);
			log.info(pstat.toString());
			rs = pstat.executeQuery();
			while(rs.next()){
				QuestionAnalysisAnswer qaa = new QuestionAnalysisAnswer();
				qaa.setAnalysisDesc(rs.getString("ANALYSIS_DESC"));
				qaa.setAnalysisUrl(BASE_URL+rs.getString("ANALYSIS_URL"));
				qaa.setAnswer(rs.getString("ANSWER"));
				qaa.setAnswerDesc(rs.getString("ANSWER_DESC"));
				qaa.setAnswerNo(rs.getInt("ANSWER_NO"));
				qaa.setAnswerUrl(BASE_URL+rs.getString("ANSWER_URL"));
				qaa.setCreateAt(rs.getTimestamp("CREATE_AT"));
				qaa.setId(rs.getLong("ID"));
				qaa.setQuestionId(rs.getLong("QUESTION_ID"));
				qaa.setTeacherUserName(rs.getString("TEACHER_USERNAME"));
				analysisList.add(qaa);
			}
		} catch (Exception e) {
			log.error("查询QuestionAnalysisAnswer出现异常......", e);
			throw e;
		}finally{
			try {
				if (pstat != null)
					pstat.close();
				if (rs != null)
					rs.close();
			} catch (Exception ex) {
				log.error("查询QuestionAnalysisAnswer关闭RS或者PS出现异常......", ex);
				throw ex;
			}
		}
		return analysisList;
	}

	@Override
	public List<QuestionAnalysisAnswer> getQuestionAnalysisAnswerAll()
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QuestionAnalysisAnswer> getQuestionAnalysisAnswers(
			Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
