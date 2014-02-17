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
import com.haotiben.feedback.biz.QuestionFeedBackBiz;
import com.haotiben.feedback.biz.RemarkBiz;
import com.haotiben.feedback.json.FeedBack;
import com.haotiben.feedback.json.QuestionFeedBack;
import com.haotiben.feedback.json.TeacherFeedBackTop;

@Path("/remark/")
public class FeedBackController {
	private static Logger log = Logger.getLogger(FeedBackController.class);
	private BizFactory factory = null;
	private RemarkBiz rBiz = null;
	private QuestionFeedBackBiz qfbBiz = null;
	/**
	 * 查询用户意见反馈列表信息
	 * @param json
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("/{json}.json")
	@Produces(MediaType.APPLICATION_JSON)
	public FeedBack getRemark(@PathParam("json") String json)throws Exception{
		FeedBack fb = new FeedBack();
		try {
			factory = BizFactory.newInstance();
			rBiz = factory.getRemarkBiz();
			fb = rBiz.getFeedBack(json);
		}  catch (BOException be) {
			log.info("getRemark------" + be.getErrorMessage().getError());
			throw new RestRequestException(be.getErrorMessage());
		} catch (Exception e) {
			log.error("", e);
		}
		return fb;
	}
	/**
	 * 获取单题反馈信息
	 * @param questionId
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("/questionid/{questionId}.json")
	@Produces(MediaType.APPLICATION_JSON)
	public QuestionFeedBack getQuestionFeedBack(@PathParam("questionId") String questionId)throws Exception{
		QuestionFeedBack questionFeedBack = new QuestionFeedBack();
		try {
			factory = BizFactory.newInstance();
			qfbBiz = factory.getQuestionFeedBackBiz();
			questionFeedBack = qfbBiz.getSingleQuestionFeedBack(questionId);
		}  catch (BOException be) {
			log.info("getQuestionFeedBack------" + be.getErrorMessage().getError());
			throw new RestRequestException(be.getErrorMessage());
		} catch (Exception e) {
			log.error("", e);
		}
		return questionFeedBack;
	}
	/**
	 * 获取老师被评价不满意的TOP列表名单
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("/feedback/top.json")
	@Produces(MediaType.APPLICATION_JSON)
	public TeacherFeedBackTop getTeacherFeedBackTop() throws Exception{
		TeacherFeedBackTop tft = new TeacherFeedBackTop();
		try {
			factory = BizFactory.newInstance();
			rBiz = factory.getRemarkBiz();
			tft = rBiz.getTeacherFeedBackTop();
		}  catch (BOException be) {
			log.info("getTeacherFeedBackTop------" + be.getErrorMessage().getError());
			throw new RestRequestException(be.getErrorMessage());
		} catch (Exception e) {
			log.error("", e);
		}
		return tft;
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
		public FeedBack getQuestionexportexecl(@PathParam("json") String json) throws Exception{
			FeedBack fb = new FeedBack();
			try {
				factory = BizFactory.newInstance();
				rBiz = factory.getRemarkBiz();
				fb = rBiz.getFeedbackExecl(json);
			}  catch (BOException be) {
				log.info("getQuestion------" + be.getErrorMessage().getError());
				throw new RestRequestException(be.getErrorMessage());
			} catch (Exception e) {
				log.error("", e);
			}
			return fb;
		}
}
