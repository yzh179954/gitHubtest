package com.haotiben.feedback.dao.impl;

import java.sql.Connection;

import com.haotiben.feedback.database.BaseDao;

public class BaseDaoImpl implements BaseDao {

	private Connection connection = null;

	public BaseDaoImpl() {
		super();
	}

	public BaseDaoImpl(Connection connection) {
		super();
		this.connection = connection;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
