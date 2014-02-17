package com.haotiben.feedback.dao.impl;

import java.sql.Connection;

import com.haotiben.feedback.dao.BaseInfoDao;
import com.haotiben.feedback.dao.DaoFactory;
import com.haotiben.feedback.dao.QuestionAnalysisAnswerDao;
import com.haotiben.feedback.dao.QuestionDao;
import com.haotiben.feedback.dao.QuestionKnowledgeDao;
import com.haotiben.feedback.dao.QuestionRemarkDao;
import com.haotiben.feedback.dao.RemarkDao;
import com.haotiben.feedback.dao.SchoolStageDao;
import com.haotiben.feedback.dao.SubjectDao;
import com.haotiben.feedback.database.Database;

public class DaoFactoryImpl extends DaoFactory {
	private Connection connection;

	public DaoFactoryImpl() {
		super();
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Connection getConnection() throws Exception {
		if (connection != null) {
			return this.connection;
		}
		System.out.println(" 获取题库数据库乱接  ");
		return new Database().getConnection();
	}

	@Override
	public void beginTransaction() throws Exception {
		this.connection = getConnection();
		connection.setAutoCommit(false);
	}

	@Override
	public void commit() throws Exception {
		this.connection.commit();
	}

	@Override
	public void rollBack() throws Exception {
		this.connection.rollback();
	}

	@Override
	public void release() throws Exception {
		if (connection != null)
			connection.close();
	}

	@Override
	public RemarkDao getRemarkDao() throws Exception {
		RemarkDaoImpl dao = new RemarkDaoImpl();
		dao.setConnection(getConnection());
		return dao;
	}

	@Override
	public QuestionAnalysisAnswerDao getQuestionAnalysisAnswerDao()
			throws Exception {
		QuestionAnalysisAnswerDaoImpl dao = new QuestionAnalysisAnswerDaoImpl();
		dao.setConnection(getConnection());
		return dao;
	}

	@Override
	public QuestionDao getQuestionDao() throws Exception {
		QuestionDaoImpl dao = new QuestionDaoImpl();
		dao.setConnection(getConnection());
		return dao;
	}

	@Override
	public QuestionRemarkDao getQuestionRemarkDao() throws Exception {
		QuestionRemarkDaoImpl dao = new QuestionRemarkDaoImpl();
		dao.setConnection(getConnection());
		return dao;
	}

	@Override
	public SubjectDao getSubjectDao() throws Exception {
		SubjectDaoImpl dao = new SubjectDaoImpl();
		dao.setConnection(getConnection());
		return dao;
	}

	@Override
	public SchoolStageDao getSchoolStageDao() throws Exception {
		SchoolStageDaoImpl dao = new SchoolStageDaoImpl();
		dao.setConnection(getConnection());
		return dao;
	}

	@Override
	public BaseInfoDao getBaseInfoDao() throws Exception {
		BaseInfoDaoImpl dao = new BaseInfoDaoImpl();
		dao.setConnection(getConnection());
		return dao;
	}

	@Override
	public QuestionKnowledgeDao getQuestionKnowledge() throws Exception {
		QuestionKnowledgeDaoImpl dao = new QuestionKnowledgeDaoImpl();
		dao.setConnection(getConnection());
		return dao;
	}


}
