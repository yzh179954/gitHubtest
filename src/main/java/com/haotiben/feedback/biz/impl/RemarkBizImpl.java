package com.haotiben.feedback.biz.impl;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import com.haotiben.feedback.VO.Page;
import com.haotiben.feedback.VO.SearchValue;
import com.haotiben.feedback.VO.TeacherTop;
import com.haotiben.feedback.biz.BaseInfoBiz;
import com.haotiben.feedback.biz.BizFactory;
import com.haotiben.feedback.biz.RemarkBiz;
import com.haotiben.feedback.controller.client.TeacherController;
import com.haotiben.feedback.dao.DaoFactory;
import com.haotiben.feedback.dao.RemarkDao;
import com.haotiben.feedback.json.FeedBack;
import com.haotiben.feedback.json.TeacherFeedBackTop;
import com.haotiben.feedback.model.QuestionRemark;
import com.haotiben.feedback.model.Remark;

public class RemarkBizImpl implements RemarkBiz {
	private static Logger log = Logger.getLogger(RemarkBizImpl.class);
	private DaoFactory factory = null;
	private BizFactory bizFactory = null;
	private RemarkDao rDao = null;
	private TeacherController tc = new TeacherController();
	private BaseInfoBiz bBiz = null;

	@Override
	public FeedBack getFeedBack(String json) throws Exception {
		FeedBack fb = new FeedBack();
		Page page = null;
		List<Remark> remarks = null;
		SearchValue sv = new SearchValue();
		try {
			factory = DaoFactory.newInstance();
			factory.beginTransaction();
			rDao = factory.getRemarkDao();
			sv = getSearchValue(json);
			page = rDao.getPage(getSql(sv, "totalRow", null), sv.pageCount,
					sv.pageSize);
			log.info("查询总记录数为： " + page.getTotalRow() + " 當前頁 : "
					+ page.getCount() + " 总页数: " + page.getTotal());
			if ((page.getCount() < page.getTotal() || page.getCount() == page
					.getTotal()) && page.getTotalRow() > 0) {
				remarks = getRemarks(sv, rDao, page);// rDao.getPageRemarks(getSql(sv,
														// "RS", page));
				log.info("查询当前页的记录数 : " + remarks.size());
				factory.commit();
				fb.remarks = remarks;
				fb.total = page.getTotal();
				fb.currentPage = page.getCount();
				fb.pageSize = page.getPageSize();
				fb.count=page.getTotalRow();
			}
		} catch (Exception e) {
			log.error("方法  getFeedBack 出现异常......", e);
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
		return fb;
	}


	/**
	 * 获取返回报表信息
	 *
	 * @return
	 * @throws Exception
	 */
	public List<Remark> getRemarks(SearchValue sv, RemarkDao rDao, Page page)
			throws Exception {
		List<Remark> remarks = null;
		try {
			bizFactory = BizFactory.newInstance();
			bBiz = bizFactory.getBaseInfoBiz();
			remarks = rDao.getPageRemarks(getSql(sv, "RS", page));
			if (!remarks.isEmpty()) {
				for (Remark r : remarks) {
					r.subject = bBiz.getBaseInfo("SUBJECT", r.subject);
				}
			}
		} catch (Exception e) {
			log.error("", e);
		}
		return remarks;
	}

	/**
	 * 将JSON字符串转化为对象SearchValue
	 *
	 * @param json
	 * @return
	 * @throws Exception
	 */
	public SearchValue getSearchValue(String json) throws Exception {
		SearchValue sv = null;
		try {
			json = URLDecoder.decode(json, "utf-8");
			ObjectMapper mapper = new ObjectMapper();
			sv = mapper.readValue(json.getBytes("utf-8"), SearchValue.class);
		} catch (Exception e) {
			log.error("", e);
		}
		return sv;
	}

	/**
	 * 根据状态type返回需要查询的SQL语句
	 *
	 * @param sValue
	 *            查询条件
	 * @param type
	 *            查询状态 totalRow(总记录数),RS(查询结果集)
	 * @return
	 * @throws Exception
	 */
	public String getSql(SearchValue sv, String type, Page page)
			throws Exception {
		StringBuffer sql = new StringBuffer("");
		try {
			if (type.equals("totalRow")) {
				// 查询记录数的SQL
				sql.append("SELECT count(DISTINCT QUESTION_REMARK.QUESTION_ID) ");
			}
			if (type.equals("RS")) {
				// 查询结果集的SQL
				sql.append("SELECT QUESTION.ID as questionId,QUESTION.IMAGE_URL as imageUrl,QUESTION.STUDENT_USERNAME as studentUserName,QUESTION_ANALYSIS_ANSWER.TEACHER_USERNAME as teacherUserName,QUESTION_REMARK.REMARK_TYPE as remarkType,QUESTION_REMARK.CREATE_AT as remarkTime,QUESTION_REMARK.REMARK as remark,QUESTION.SUBJECT_CODE as subject,QUESTION.CREATE_AT as questionUpTime,QUESTION_ANALYSIS_ANSWER.CREATE_AT as questionResolveTime,QUESTION_FETCH.CREATE_AT as questionfetchtime ");

			}
			sql.append("from QUESTION,QUESTION_ANALYSIS_ANSWER,QUESTION_REMARK,QUESTION_FETCH where QUESTION.ID=QUESTION_ANALYSIS_ANSWER.QUESTION_ID and QUESTION.ID=QUESTION_REMARK.QUESTION_ID and QUESTION.ID=QUESTION_FETCH.QUESTION_ID");
			// 开始组装动态参数条件
			if (sv.remarkType != -1)
				sql.append(" and QUESTION_REMARK.REMARK_TYPE = "
						+ sv.remarkType);
			else
				sql.append(" and (QUESTION_REMARK.REMARK_TYPE = 1 or QUESTION_REMARK.REMARK_TYPE = 0) ");
			if (sv.schoolStageCode != null && !sv.schoolStageCode.trim().equals(""))
				sql.append(" and QUESTION.SCHOOL_STAGE_CODE = '"
						+ sv.schoolStageCode + "'");
			if (sv.studentUserName != null && !sv.studentUserName.trim().equals(""))
				sql.append(" and QUESTION.STUDENT_USERNAME = '"
						+ sv.studentUserName + "'");
			if (sv.subjectCode != null && !sv.subjectCode.trim().equals(""))
				sql.append(" and QUESTION.SUBJECT_CODE ='" + sv.subjectCode
						+ "'");
			if (sv.teacherUserName != null && !sv.teacherUserName.trim().equals(""))
				sql.append(" and QUESTION_ANALYSIS_ANSWER.TEACHER_USERNAME = '"
						+ sv.teacherUserName + "'");

//			if(sv.datebegin!=null&&!"".equals(sv.datebegin)&&sv.dateend!=null&&!"".equals(sv.dateend)){
//			sql.append(" and QUESTION_REMARK.CREATE_AT>='"+sv.datebegin+"' and QUESTION_REMARK.CREATE_AT<='"+sv.dateend+"'");
//			}
//			else if(sv.datebegin!=null&&sv.dateend==null){
//				sql.append(" and QUESTION_REMARK.CREATE_AT>='"+sv.datebegin+"'");
//
//			}
//			else if(sv.dateend!=null&&sv.datebegin==null){
//				sql.append(" and QUESTION_REMARK.CREATE_AT<='"+sv.dateend+"'");
//			}
			System.out.println("-----------"+sv.datebegin);
			if(sv.datebegin !=null&&!"".equals(sv.datebegin)){
				System.out.println("*********************");
				sql.append(" and QUESTION_REMARK.CREATE_AT>='"+sv.datebegin+"'");
			}
			if(sv.dateend!=null&&!"".equals(sv.dateend)){
				sql.append(" and QUESTION_REMARK.CREATE_AT<='"+sv.dateend+"'");
			}
			if (sv.order == null || sv.order.equals(""))
				sv.order = "asc";
			if(type.equals("RS"))


				sql.append(" GROUP BY QUESTION.ID ");
			sql.append("  order by QUESTION_REMARK.CREATE_AT " + sv.order);
			if (page != null)
				sql.append(" limit " + page.getBeginIndex() + ","
						+ page.getPageSize() + " ");
			log.info("sql : " + sql);
		} catch (Exception e) {
			log.error("方法  getSql 出现异常......", e);
			throw e;
		}
		return sql.toString();
	}

	@Override
	public QuestionRemark getRemark(String questionId) throws Exception {
		QuestionRemark remark = null;
		try {
			factory = DaoFactory.newInstance();
			factory.beginTransaction();
			rDao = factory.getRemarkDao();
			remark = rDao.getRemark(Long.valueOf(questionId));
			factory.commit();
		} catch (Exception e) {
			log.error("方法  getRemark 出现异常......", e);
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
		return remark;
	}

	@Override
	public TeacherFeedBackTop getTeacherFeedBackTop() throws Exception {
		TeacherFeedBackTop tft = new TeacherFeedBackTop();
		List<TeacherTop> tTop = new ArrayList<TeacherTop>();
		try {
			factory = DaoFactory.newInstance();
			factory.beginTransaction();
			rDao = factory.getRemarkDao();
			tTop = rDao.getTeacherTop();
			factory.commit();
			for (TeacherTop t : tTop) {
				t.name = tc.getTeacherInfo(t.userName).getRealName();
			}
			tft.teacherTop = tTop;
		} catch (Exception e) {
			log.error("方法  getTeacherFeedBackTop 出现异常......", e);
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
		return tft;
	}


	@Override
	public FeedBack getFeedbackExecl(String json) throws Exception {
		FeedBack fb = new FeedBack();
		Page page = null;
		List<Remark> remarks = null;
		SearchValue sv = new SearchValue();
		try {
			factory = DaoFactory.newInstance();
			factory.beginTransaction();
			rDao = factory.getRemarkDao();
			sv = getSearchValue(json);
				remarks = getRemarks(sv, rDao, page);
				factory.commit();
				fb.remarks = remarks;
		} catch (Exception e) {
			log.error("方法  getFeedBack 出现异常......", e);
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
		return fb;
	}
}
