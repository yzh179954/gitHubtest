package com.haotiben.feedback.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.haotiben.feedback.biz.QuestionKnowledgeBiz;
import com.haotiben.feedback.dao.DaoFactory;
import com.haotiben.feedback.dao.QuestionKnowledgeDao;
import com.haotiben.feedback.json.QuestionKnowledge;

public class QuestionKnowledgeBizImpl implements QuestionKnowledgeBiz {
	private static Logger log = Logger.getLogger(QuestionBizImpl.class);
	private DaoFactory factory = null;
	private QuestionKnowledgeDao qkDao = null;
	@Override
	public List<QuestionKnowledge> getQuestionKnowledge(String questionId)
			throws Exception {
		log.info("getQuestionKnowledge questionId:"+questionId);
		List<QuestionKnowledge> qknowledgeList = null;
		try {
			factory = DaoFactory.newInstance();
			qkDao = factory.getQuestionKnowledge();
			qknowledgeList = qkDao.getQuestionKnowledges(Long.valueOf(questionId));
		} catch (Exception e) {
			log.error("方法  getQuestionKnowledge 出现异常......", e);
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
		return qknowledgeList;
	}

}
