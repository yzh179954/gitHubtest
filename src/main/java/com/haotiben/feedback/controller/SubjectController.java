package com.haotiben.feedback.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.haotiben.feedback.biz.BizFactory;
import com.haotiben.feedback.biz.SubjectBiz;
import com.haotiben.feedback.json.Subjects;

@Path("/baseinfo/subject/")
public class SubjectController {
	private static Logger log = Logger.getLogger(FeedBackController.class);
	private BizFactory factory = null;
	private SubjectBiz sBiz = null;
	@GET
	@Path("/all.json")
	@Produces(MediaType.APPLICATION_JSON)
	public Subjects getSubjects()throws Exception{
		Subjects subjects = new Subjects();
		try {
			factory = BizFactory.newInstance();
			sBiz = factory.getSubjectBiz();
			subjects = sBiz.getSubjects();
		} catch (Exception e) {
			log.error("", e);
		}
		return subjects;
	}
}
