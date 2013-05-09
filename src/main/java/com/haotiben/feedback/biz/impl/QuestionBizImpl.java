package com.haotiben.feedback.biz.impl;

import java.net.URLDecoder;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import com.haotiben.feedback.VO.Page;
import com.haotiben.feedback.VO.SearchValue;
import com.haotiben.feedback.biz.BaseInfoBiz;
import com.haotiben.feedback.biz.BizFactory;
import com.haotiben.feedback.biz.QuestionBiz;
import com.haotiben.feedback.dao.DaoFactory;
import com.haotiben.feedback.dao.QuestionDao;
import com.haotiben.feedback.json.FeedBack;
import com.haotiben.feedback.model.Question;
import com.haotiben.feedback.model.Remark;

public class QuestionBizImpl implements QuestionBiz {
	private static Logger log = Logger.getLogger(QuestionBizImpl.class);
	private DaoFactory factory = null;
	private QuestionDao qDao = null;
	private BizFactory bizFactory = null;
	private BaseInfoBiz bBiz = null;
	@Override
	public Question getQuestion(long questionId) throws Exception {
		log.info("getQuestion questionId:"+questionId);
		Question q = null;
		try {
			factory = DaoFactory.newInstance();
			factory.beginTransaction();
			qDao = factory.getQuestionDao();
			q = qDao.getQuestionById(questionId);
			factory.commit();
		} catch (Exception e) {
			log.error("方法  getQuestion 出现异常......", e);
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
		return q;
	}
	@Override
	public FeedBack getQuestion(String json) throws Exception {
		FeedBack fb = new FeedBack();
		Page page = null;
		List<Remark> remarks = null;
		SearchValue sv = new SearchValue();
		try {
			factory = DaoFactory.newInstance();
			factory.beginTransaction();
			qDao = factory.getQuestionDao();
			sv = getSearchValue(json);
			page = qDao.getPage(getSql(sv, "totalRow", null), sv.pageCount,
					sv.pageSize);
			log.info("查询总记录数为： " + page.getTotalRow() + " 當前頁 : "
					+ page.getCount() + " 总页数: " + page.getTotal());
			if ((page.getCount() < page.getTotal() || page.getCount() == page
					.getTotal()) && page.getTotalRow() > 0) {
				remarks = getRemarks(sv, qDao, page);// rDao.getPageRemarks(getSql(sv,
														// "RS", page));
				log.info("查询当前页的记录数 : " + remarks.size());
				factory.commit();
				fb.remarks = remarks;
				fb.total = page.getTotal();
				fb.currentPage = page.getCount();
				fb.pageSize = page.getPageSize();
				fb.count = page.getTotalRow();
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
	public List<Remark> getRemarks(SearchValue sv, QuestionDao qDao, Page page)
			throws Exception {
		List<Remark> remarks = null;
		try {
			bizFactory = BizFactory.newInstance();
			bBiz = bizFactory.getBaseInfoBiz();
			remarks = qDao.getPageRemarks(getSql(sv, "RS", page));
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
				sql.append("SELECT count(DISTINCT QUESTION.ID) ");
			}
			if (type.equals("RS")) {
				// 查询结果集的SQL
				sql.append("SELECT QUESTION.ID as questionId,QUESTION.IMAGE_URL as imageUrl,QUESTION.STUDENT_USERNAME as studentUserName,QUESTION_ANALYSIS_ANSWER.TEACHER_USERNAME as teacherUserName,QUESTION.SUBJECT_CODE as subject,QUESTION.CREATE_AT as questionUpTime,QUESTION_ANALYSIS_ANSWER.CREATE_AT as questionResolveTime  ");

			}
			sql.append(" from QUESTION left join QUESTION_ANALYSIS_ANSWER on QUESTION.ID=QUESTION_ANALYSIS_ANSWER.QUESTION_ID  where QUESTION.ID > 0  and QUESTION.HELP = 1 ");
			// 开始组装动态参数条件

			if (sv.schoolStageCode != null && !sv.schoolStageCode.equals(""))
				sql.append(" and QUESTION.SCHOOL_STAGE_CODE = '"
						+ sv.schoolStageCode + "'");
			if (sv.studentUserName != null && !sv.studentUserName.equals(""))
				sql.append(" and QUESTION.STUDENT_USERNAME = '"
						+ sv.studentUserName + "'");
			if (sv.subjectCode != null && !sv.subjectCode.equals(""))
				sql.append(" and QUESTION.SUBJECT_CODE ='" + sv.subjectCode
						+ "'");
			if(!sv.questionType.equals("all")){
				if(sv.questionType == null || sv.questionType.equals("")){
					sql.append(" and QUESTION.STATUS = ' ' ");
				}else{
					sql.append(" and QUESTION.STATUS = '"+sv.questionType+"' ");
				}
			}
			if (sv.teacherUserName != null && !sv.teacherUserName.equals(""))
				sql.append(" and QUESTION_ANALYSIS_ANSWER.TEACHER_USERNAME = '"
						+ sv.teacherUserName + "'");
			if (sv.order == null || sv.order.equals(""))
				sv.order = "asc";
			if(type.equals("RS"))
				sql.append(" GROUP BY QUESTION.ID ");
			sql.append("  order by QUESTION.CREATE_AT " + sv.order);
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
}
