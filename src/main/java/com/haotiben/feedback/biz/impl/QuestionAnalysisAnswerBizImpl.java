package com.haotiben.feedback.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.haotiben.feedback.Exception.BOException;
import com.haotiben.feedback.biz.QuestionAnalysisAnswerBiz;
import com.haotiben.feedback.dao.DaoFactory;
import com.haotiben.feedback.dao.QuestionAnalysisAnswerDao;
import com.haotiben.feedback.model.QuestionAnalysisAnswer;

public class QuestionAnalysisAnswerBizImpl implements QuestionAnalysisAnswerBiz {
	private static Logger log = Logger.getLogger(QuestionAnalysisAnswerBizImpl.class);
	private DaoFactory factory = null;
	private QuestionAnalysisAnswerDao qaaDao = null;
	@Override
	public List<QuestionAnalysisAnswer> getQuestionAnalysisAnswerByQuestionId(
			long questionId) throws Exception {
		log.info("getQuestionAnalysisAnswerByQuestionId questionId:"+questionId);
		List<QuestionAnalysisAnswer> list = null;
		try {
			factory = DaoFactory.newInstance();
			factory.beginTransaction();
			qaaDao = factory.getQuestionAnalysisAnswerDao();
			list = qaaDao.getQuestionAnalysisAnswerByQuestionId(questionId);
			factory.commit();
		} catch (BOException boe) {
			log.error("", boe);
			throw boe;
		} catch (Exception e) {
			log.error("方法  getQuestionAnalysisAnswerByQuestionId 出现异常......", e);
			throw e;
		} finally {
			try {
				factory.release();
				log.info("Connection is closed......");
			} catch (Exception e2) {
				log.error("Connection closeing error....", e2);
			}
		}
		return list;
	}
	@Override
	public QuestionAnalysisAnswer getQuestionAnalysisAnswerByID(String id)
			throws Exception {
		log.info("getQuestionAnalysisAnswerByID ID:"+id);
		QuestionAnalysisAnswer qaa = null;
		try {
			factory = DaoFactory.newInstance();
			factory.beginTransaction();
			qaaDao = factory.getQuestionAnalysisAnswerDao();
			qaa = qaaDao.getQuestionAnalysisAnswerById(Long.valueOf(id));
			factory.commit();
		} catch (BOException boe) {
			log.error("", boe);
			throw boe;
		} catch (Exception e) {
			log.error("方法  getQuestionAnalysisAnswerByQuestionId 出现异常......", e);
			throw e;
		} finally {
			try {
				factory.release();
				log.info("Connection is closed......");
			} catch (Exception e2) {
				log.error("Connection closeing error....", e2);
			}
		}
		return qaa;
	}

}
