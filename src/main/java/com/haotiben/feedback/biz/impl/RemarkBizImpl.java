package com.haotiben.feedback.biz.impl;

import java.net.URLDecoder;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import com.haotiben.feedback.VO.Page;
import com.haotiben.feedback.VO.SearchValue;
import com.haotiben.feedback.biz.RemarkBiz;
import com.haotiben.feedback.dao.DaoFactory;
import com.haotiben.feedback.dao.RemarkDao;
import com.haotiben.feedback.json.FeedBack;
import com.haotiben.feedback.model.QuestionRemark;
import com.haotiben.feedback.model.Remark;

public class RemarkBizImpl implements RemarkBiz {
	private static Logger log = Logger.getLogger(RemarkBizImpl.class);
	private DaoFactory factory = null;
	private RemarkDao rDao = null;

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
			page = rDao.getPage(getSql(sv, "totalRow", page), sv.pageCount,
					sv.pageSize);
			log.info("查询总记录数为： " + page.getTotalRow() + " 當前頁 : "
					+ page.getCount() + " 总页数: " + page.getTotal());
			if ((page.getCount() < page.getTotal() || page.getCount() == page
					.getTotal()) && page.getTotalRow() > 0) {
				remarks = rDao.getPageRemarks(getSql(sv, "RS", page));
				log.info("查询当前页的记录数 : " + remarks.size());
				factory.commit();
				fb.remarks = remarks;
				fb.total = page.getTotal();
				fb.currentPage = page.getCount();
				fb.pageSize = page.getPageSize();
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
				sql.append("SELECT count(distinct question.ID) ");
			}
			if (type.equals("RS")) {
				// 查询结果集的SQL
				sql.append("SELECT distinct question.ID as questionId,question.IMAGE_URL as imageUrl,question.STUDENT_USERNAME as studentUserName,question_analysis_answer.TEACHER_USERNAME as teacherUserName,question_remark.REMARK_TYPE as remarkType,question_remark.CREATE_AT as remarkTime,question_remark.REMARK as remark ");
			}
			sql.append("from question,question_analysis_answer,question_remark where question.ID=question_analysis_answer.QUESTION_ID and question.ID=question_remark.QUESTION_ID ");
			// 开始组装动态参数条件
			if(sv.remarkType != 0)
				sql.append(" and question_remark.REMARK_TYPE = " + sv.remarkType);
			else
				sql.append(" and (question_remark.REMARK_TYPE = 1 or question_remark.REMARK_TYPE = 2) ");
			if (sv.schoolStageCode != null && !sv.schoolStageCode.equals(""))
				sql.append(" and question.SCHOOL_STAGE_CODE = '"
						+ sv.schoolStageCode + "'");
			if (sv.studentUserName != null && !sv.studentUserName.equals(""))
				sql.append(" and question.STUDENT_USERNAME = '"
						+ sv.studentUserName + "'");
			if (sv.subjectCode != null && !sv.subjectCode.equals(""))
				sql.append("and question.SUBJECT_CODE ='" + sv.subjectCode
						+ "'");
			if (sv.teacherUserName != null && !sv.teacherUserName.equals(""))
				sql.append(" and question_analysis_answer.TEACHER_USERNAME = '"
						+ sv.teacherUserName + "'");
			if (sv.order == null || sv.order.equals(""))
				sv.order = "asc";
			sql.append(" order by question_remark.CREATE_AT " + sv.order);
			if (page != null)
				sql.append(" limit " + page.getBeginIndex() + ","
						+ page.getEndIndex() + " ");
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
}
