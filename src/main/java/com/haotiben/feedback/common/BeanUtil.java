package com.haotiben.feedback.common;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import com.haotiben.feedback.json.QuestionJson;
import com.haotiben.feedback.model.Question;

public class BeanUtil {
	static {
		ConvertUtils.register(new DateConvert(), java.util.Date.class);
		ConvertUtils.register(new DateConvert(), java.sql.Date.class);
	}

	/**
	 * 转换单个bean
	 *
	 * @param toObject
	 * @param fromObject
	 * @return
	 * @throws Exception
	 */
	public static Object getPOToVO(Object vo, Object po) throws Exception {
		try {
			BeanUtils.copyProperties(vo, po);
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (InvocationTargetException ex) {
			ex.printStackTrace();
		}
		return vo;
	}

	public static void main(String[] args) {
		Question q = new Question();
		q.setBookCode("1");
		QuestionJson qJson = new QuestionJson();
		try {
			getPOToVO(qJson, q);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(qJson.bookCode);
	}
}
