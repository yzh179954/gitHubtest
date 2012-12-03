package com.haotiben.feedback.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.haotiben.feedback.Exception.BOException;
import com.haotiben.feedback.Exception.RestRequestException;
import com.haotiben.feedback.biz.BizFactory;
import com.haotiben.feedback.biz.QuestionAnalysisAnswerBiz;
import com.haotiben.feedback.model.QuestionAnalysisAnswer;

@Path("/analysis/")
public class AnalysisAnswerController {
	private static Logger log = Logger.getLogger(AnalysisAnswerController.class);
	private BizFactory factory = null;
	private QuestionAnalysisAnswerBiz qaaBiz = null;
	@GET
	@Path("/{analysisId}.json")
	@Produces(MediaType.APPLICATION_JSON)
	public QuestionAnalysisAnswer getQuestionAnalysisAnswer(@PathParam("analysisId") String analysisId)throws Exception{
		QuestionAnalysisAnswer qaa = new QuestionAnalysisAnswer();
		try {
			factory = BizFactory.newInstance();
			qaaBiz = factory.getQuestionAnalysisAnswerBiz();
			qaa = qaaBiz.getQuestionAnalysisAnswerByID(analysisId);
		}  catch (BOException be) {
			log.info("getQuestionFeedBack------" + be.getErrorMessage().getError());
			throw new RestRequestException(be.getErrorMessage());
		} catch (Exception e) {
			log.error("", e);
		}
		return qaa;
	}
}
