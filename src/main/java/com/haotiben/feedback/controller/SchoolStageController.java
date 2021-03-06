package com.haotiben.feedback.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.haotiben.feedback.biz.BizFactory;
import com.haotiben.feedback.biz.SchoolStageBiz;
import com.haotiben.feedback.json.SchoolStages;

@Path("/baseinfo/schoolstage/")
public class SchoolStageController {
	private static Logger log = Logger.getLogger(FeedBackController.class);
	private BizFactory factory = null;
	private SchoolStageBiz ssBiz = null;
	@GET
	@Path("/all.json")
	@Produces(MediaType.APPLICATION_JSON)
	public SchoolStages getSchoolStages()throws Exception{
		SchoolStages schoolStages = new SchoolStages();
		try {
			factory = BizFactory.newInstance();
			ssBiz = factory.getSchoolStageBiz();
			schoolStages = ssBiz.getSchoolStage();
		} catch (Exception e) {
			log.error("", e);
		}
		return schoolStages;
	}
}
