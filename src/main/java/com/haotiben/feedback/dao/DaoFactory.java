package com.haotiben.feedback.dao;

import java.sql.Connection;

import com.haotiben.feedback.dao.impl.DaoFactoryImpl;

/**
 * DAO工厂基类
 *
 * @author davis
 */
public abstract class DaoFactory {
	protected DaoFactory() {
		super();
	}

	/**
	 * Create a factory instance
	 *
	 * @return
	 */
	public static DaoFactory newInstance() throws Exception {
		return new DaoFactoryImpl();
	}

	/**
	 * 获取信息反馈数据库连接对象
	 *
	 * @return 数据库连接对象
	 * @throws Exception
	 */
	public abstract Connection getConnection() throws Exception;

	/**
	 * 启动题库事务
	 *
	 * @param connection
	 */
	public abstract void beginTransaction() throws Exception;

	/**
	 * 提交事务
	 *
	 * @param connection
	 */
	public abstract void commit() throws Exception;

	/**
	 * 回滚事务
	 *
	 * @throws Exception
	 */
	public abstract void rollBack() throws Exception;

	/**
	 * 关闭连接
	 *
	 * @throws Exception
	 */
	public abstract void release() throws Exception;

	/**
	 * 获取RemarkDao
	 *
	 * @return
	 * @throws Exception
	 */
	public abstract RemarkDao getRemarkDao() throws Exception;

	/**
	 * 获取QuestionAnalysisAnswerDao
	 *
	 * @return
	 * @throws Exception
	 */
	public abstract QuestionAnalysisAnswerDao getQuestionAnalysisAnswerDao()
			throws Exception;

	/**
	 * 获取QuestionDao
	 *
	 * @return
	 * @throws Exception
	 */
	public abstract QuestionDao getQuestionDao() throws Exception;

	/**
	 * 获取QuestionRemarkDao
	 *
	 * @return
	 * @throws Exception
	 */
	public abstract QuestionRemarkDao getQuestionRemarkDao() throws Exception;

	/**
	 * 获取SubjectDao
	 *
	 * @return
	 * @throws Exception
	 */
	public abstract SubjectDao getSubjectDao() throws Exception;

	/**
	 * 获取SchoolStageDao
	 *
	 * @return
	 * @throws Exception
	 */
	public abstract SchoolStageDao getSchoolStageDao() throws Exception;

	/**
	 * 获取BaseInfoDao
	 *
	 * @return
	 * @throws Exception
	 */
	public abstract BaseInfoDao getBaseInfoDao() throws Exception;

	public abstract QuestionKnowledgeDao getQuestionKnowledge()
			throws Exception;
}
