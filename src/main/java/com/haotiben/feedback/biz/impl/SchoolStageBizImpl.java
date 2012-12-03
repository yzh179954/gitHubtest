package com.haotiben.feedback.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.haotiben.feedback.biz.SchoolStageBiz;
import com.haotiben.feedback.dao.DaoFactory;
import com.haotiben.feedback.dao.SchoolStageDao;
import com.haotiben.feedback.json.SchoolStages;
import com.haotiben.feedback.model.SchoolStage;

public class SchoolStageBizImpl implements SchoolStageBiz {
	private static Logger log = Logger.getLogger(SchoolStageBizImpl.class);
	private DaoFactory factory = null;
	private SchoolStageDao ssDao = null;
	@Override
	public SchoolStages getSchoolStage() throws Exception {
		SchoolStages schoolStages = new SchoolStages();
		List<SchoolStage>  ssList = new ArrayList<SchoolStage>();
		try {
			factory = DaoFactory.newInstance();
			factory.beginTransaction();
			ssDao = factory.getSchoolStageDao();
			ssList = ssDao.getSchoolStageList();
			factory.commit();
			schoolStages.stages = ssList;
		} catch (Exception e) {
			log.error("方法  getSchoolStage 出现异常......", e);
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
		return schoolStages;
	}

}
