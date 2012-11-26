package com.haotiben.feedback.dao.impl;

import java.sql.Connection;

import com.haotiben.feedback.dao.DaoFactory;
import com.haotiben.feedback.dao.RemarkDao;
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

}
