package com.haotiben.feedback.common;

import java.util.ResourceBundle;

/**
 * 配置对象
 * @author davis
 */
public class Resource {

	private static final ResourceBundle config = ResourceBundle.getBundle("dbinfo");

	/**
	 * 私有的防止被实例化
	 */
	private Resource(){}

	/**
	 * 根据key获取配置信息
	 * @param key
	 * @return
	 */
	public static String getString(String key) {
		return config.getString(key);
	}
}
