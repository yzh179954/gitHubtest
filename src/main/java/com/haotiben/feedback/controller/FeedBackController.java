package com.haotiben.feedback.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.haotiben.feedback.biz.BizFactory;
import com.haotiben.feedback.biz.RemarkBiz;
import com.haotiben.feedback.json.FeedBack;

@Path("/remark/")
public class FeedBackController {
	private static Logger log = Logger.getLogger(FeedBackController.class);
	private BizFactory factory = null;
	private RemarkBiz rBiz = null;
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
		FeedBack fb = null;
		try {
			factory = BizFactory.newInstance();
			rBiz = factory.getRemarkBiz();
//			fb = rBiz.getFeedBack(sValue, pageCount);
		} catch (Exception e) {
			log.error("", e);
		}
		return fb;
	}
//	@GET
//	@Path("/{questionId}.json")
//	@Produces(MediaType.APPLICATION_JSON)
//	public
}
