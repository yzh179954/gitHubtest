package com.haotiben.feedback.database;

import java.sql.Connection;
import java.sql.DriverManager;

import com.haotiben.feedback.common.Resource;

public class Database {
	/**
	 * 信息反馈系统
	 * @return
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception {
		Class.forName(Resource.getString("db_driverName")).newInstance();
		return DriverManager.getConnection(Resource.getString("db_url"),
				Resource.getString("db_username"),
				Resource.getString("db_password"));
	}
}
