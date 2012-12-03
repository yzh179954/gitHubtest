package com.haotiben.feedback.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.haotiben.feedback.biz.SubjectBiz;
import com.haotiben.feedback.dao.DaoFactory;
import com.haotiben.feedback.dao.SubjectDao;
import com.haotiben.feedback.json.Subjects;
import com.haotiben.feedback.model.Subject;

public class SubjectBizImpl implements SubjectBiz {
	private static Logger log = Logger.getLogger(SubjectBizImpl.class);
	private DaoFactory factory = null;
	private SubjectDao sDao = null;
	@Override
	public Subjects getSubjects() throws Exception {
		Subjects subjects = new Subjects();
		List<Subject>  sList = new ArrayList<Subject>();
		try {
			factory = DaoFactory.newInstance();
			factory.beginTransaction();
			sDao = factory.getSubjectDao();
			sList = sDao.getSubjectList();
			factory.commit();
			subjects.subjects = sList;
		} catch (Exception e) {
			log.error("方法  getSubjects 出现异常......", e);
			factory.rollBack();
			throw e;
		} finally {
			try {
				factory.release();
				log.info("Connection is closed......");
			} catch (Exception e2) {
				log.error("Connection closeing error....", e2);
			}
		}
		return subjects;
	}

}
