package com.haotiben.feedback.common;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.haotiben.feedback.json.QuestionJson;

public class ReflectUtil {
	private static Logger log = Logger.getLogger(ReflectUtil.class);
	public static String str = "";

	/**
	 * 过滤返回数据不能为NULL
	 *
	 * @param obj
	 */
	public static Object reflect(Object obj) {
		if (obj == null)
			return null;
		Field[] fields = obj.getClass().getDeclaredFields();
		try {
			for (int j = 0; j < fields.length; j++) {
				fields[j].setAccessible(true);
				if (fields[j].getType().getAnnotations().length > 0) {
					// 包含对象类型
					reflect(fields[j].get(obj));
				} else {
					// String Type
					if (fields[j].getType().getName()
							.equals(java.lang.String.class.getName())
							|| fields[j].getType().getName().equals("String")) {
						String value = (String) fields[j].get(obj);
						if (value == null) {
							log.info(fields[j].getName() + "------" + value);
							value = str;
							fields[j].set(obj, value);
						}
					}
					// Date Type
					if (fields[j].getType().getName()
							.equals(java.util.Date.class.getName())
							|| fields[j].getType().getName().equals("Date")) {
						Date value = (Date) fields[j].get(obj);
					}
					// Set Type
					if (fields[j].getType().getName()
							.equals(java.util.Set.class.getName())
							|| fields[j].getType().getName().equals("Set")) {
						Type gt = fields[j].getGenericType(); // 得到泛型类型
						ParameterizedType pt = (ParameterizedType) gt;
						Class c = (Class) pt.getActualTypeArguments()[0];
						Set s = (Set) fields[j].get(obj);
						for (Object o : s) {
							reflect(o);
						}
					}
					// List Type
					if (fields[j].getType().getName()
							.equals(java.util.List.class.getName())
							|| fields[j].getType().getName().equals("List")) {
						Type gt = fields[j].getGenericType(); // 得到泛型类型
						ParameterizedType pt = (ParameterizedType) gt;
						Class c = (Class) pt.getActualTypeArguments()[0];
						List s = (List) fields[j].get(obj);
						for (Object o : s) {
							reflect(o);
						}
					}
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * 检查对象中指定字段是否为NULL ，如果为NULL，则返回该字段名
	 *
	 * @param obj
	 * @param fieldNames
	 * @return
	 */
	public static String reflectCheckEssentialField(Object obj,
			List<String> fieldNames) {
		if (obj == null)
			return "传入对象为空";
		Field field = null;
		try {
			for (String s : fieldNames) {
				field = obj.getClass().getDeclaredField(s);
				if (field == null) {
					log.info("必要的参数不存在！！");
					return s;
				}
				if (field.get(obj) == null){
					log.info("必要的参数的值为NULL！！");
					return s;
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		return "success";
	}

	/**
	 * 过滤掉对象中指定字段不检测 ，对剩下的字段检测是否为NULL,如果为NULL，则返回该字段名
	 *
	 * @param obj
	 * @param fieldNames
	 * @return
	 */
	public static String reflectCheckUnEssentialField(Object obj,
			List<String> fieldNames) {
		return null;
	}

	public static void main(String[] args) {

	}

}
