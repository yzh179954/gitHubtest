package com.haotiben.feedback.database;

import java.sql.Connection;

public interface BaseDao {
	public Connection getConnection() throws Exception;

	public void setConnection(Connection connection) throws Exception;
}
