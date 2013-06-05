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
import com.haotiben.feedback.biz.QuestionBiz;
import com.haotiben.feedback.json.FeedBack;

@Path("/question/")
public class QuestionController {
	private static Logger log = Logger.getLogger(FeedBackController.class);
	private BizFactory factory = null;
	private QuestionBiz qBiz = null;
	/**
	 * 查询用户上传试题列表信息
	 * @param json
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("/{json}.json")
	@Produces(MediaType.APPLICATION_JSON)
	public FeedBack getQuestion(@PathParam("json") String json)throws Exception{
		FeedBack fb = new FeedBack();
		try {
			factory = BizFactory.newInstance();
			qBiz = factory.getQuestionBiz();
			fb = qBiz.getQuestion(json);
		}  catch (BOException be) {
			log.info("getQuestion------" + be.getErrorMessage().getError());
			throw new RestRequestException(be.getErrorMessage());
		} catch (Exception e) {
			log.error("", e);
		}
		return fb;
	}

	/*
	*
	*导出execl返回信息列表
	*
	*
	*/
	@GET
	@Path("/exportexecl/{json}.json")
	@Produces(MediaType.APPLICATION_JSON)
	public FeedBack getQuestionExecl(@PathParam("json") String json)throws Exception{
		FeedBack fb = new FeedBack();
		try {
			factory = BizFactory.newInstance();
			qBiz = factory.getQuestionBiz();
			fb = qBiz.getQuestionExecl(json);
		}  catch (BOException be) {
			log.info("getQuestion------" + be.getErrorMessage().getError());
			throw new RestRequestException(be.getErrorMessage());
		} catch (Exception e) {
			log.error("", e);
		}
		return fb;
	}

}
