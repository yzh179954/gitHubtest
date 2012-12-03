package com.haotiben.feedback.biz.impl;

import org.apache.log4j.Logger;

import com.haotiben.feedback.biz.QuestionBiz;
import com.haotiben.feedback.dao.DaoFactory;
import com.haotiben.feedback.dao.QuestionDao;
import com.haotiben.feedback.model.Question;

public class QuestionBizImpl implements QuestionBiz {
	private static Logger log = Logger.getLogger(QuestionBizImpl.class);
	private DaoFactory factory = null;
	private QuestionDao qDao = null;
	@Override
	public Question getQuestion(long questionId) throws Exception {
		log.info("getQuestion questionId:"+questionId);
		Question q = null;
		try {
			factory = DaoFactory.newInstance();
			factory.beginTransaction();
			qDao = factory.getQuestionDao();
			q = qDao.getQuestionById(questionId);
			factory.commit();
		} catch (Exception e) {
			log.error("方法  getQuestion 出现异常......", e);
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
		return q;
	}

}
