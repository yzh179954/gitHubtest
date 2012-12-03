package com.haotiben.feedback.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.haotiben.feedback.dao.QuestionKnowledgeDao;
import com.haotiben.feedback.json.QuestionKnowledge;
import com.haotiben.feedback.model.Knowledge;

public class QuestionKnowledgeDaoImpl extends BaseDaoImpl implements
		QuestionKnowledgeDao {
	private static Logger log = Logger.getLogger(QuestionDaoImpl.class);
	private ResultSet rs = null;
	private PreparedStatement pstat = null;
	private Connection conn = null;
	@Override
	public List<QuestionKnowledge> getQuestionKnowledges(long questionId)
			throws Exception {
		String sql = "select * from question_knowledge_synthetically where QUESTION_ID = ? ";
		List<QuestionKnowledge> knowledgeList = new ArrayList<QuestionKnowledge>();
		try {
			conn = getConnection();
			pstat = conn.prepareStatement(sql);
			pstat.setLong(1, questionId);
			log.info(pstat.toString());
			rs = pstat.executeQuery();
			while(rs.next()){
				QuestionKnowledge qk = new QuestionKnowledge();
				qk.setCode(rs.getString("KNOWLEDGE_CODE"));
				qk.setQuestionId(rs.getLong("QUESTION_ID"));
				knowledgeList.add(qk);
			}
		} catch (Exception e) {
			log.error("查询Knowledge出现异常......", e);
			throw e;
		}finally{
			try {
				if (pstat != null)
					pstat.close();
				if (rs != null)
					rs.close();
			} catch (Exception ex) {
				log.error("查询Knowledge关闭RS或者PS出现异常......", ex);
				throw ex;
			}
		}
		return knowledgeList;
	}

}
