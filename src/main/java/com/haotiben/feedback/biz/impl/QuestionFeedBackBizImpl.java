package com.haotiben.feedback.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.haotiben.feedback.Exception.BOException;
import com.haotiben.feedback.VO.StudentInfo;
import com.haotiben.feedback.VO.TeacherInfo;
import com.haotiben.feedback.biz.BaseInfoBiz;
import com.haotiben.feedback.biz.BizFactory;
import com.haotiben.feedback.biz.QuestionAnalysisAnswerBiz;
import com.haotiben.feedback.biz.QuestionBiz;
import com.haotiben.feedback.biz.QuestionFeedBackBiz;
import com.haotiben.feedback.biz.QuestionKnowledgeBiz;
import com.haotiben.feedback.biz.RemarkBiz;
import com.haotiben.feedback.common.BeanUtil;
import com.haotiben.feedback.common.ReflectUtil;
import com.haotiben.feedback.controller.client.StudentController;
import com.haotiben.feedback.controller.client.TeacherController;
import com.haotiben.feedback.json.QuestionFeedBack;
import com.haotiben.feedback.json.QuestionJson;
import com.haotiben.feedback.json.QuestionKnowledge;
import com.haotiben.feedback.json.StudentJson;
import com.haotiben.feedback.json.TeacherJson;
import com.haotiben.feedback.model.Question;
import com.haotiben.feedback.model.QuestionAnalysisAnswer;
import com.haotiben.feedback.model.QuestionRemark;

public class QuestionFeedBackBizImpl implements QuestionFeedBackBiz {
	private static Logger log = Logger.getLogger(RemarkBizImpl.class);
	private BizFactory factory = null;
	private QuestionBiz qBiz = null;
	private QuestionAnalysisAnswerBiz qaaBiz = null;
	private RemarkBiz rBiz = null;
	private BaseInfoBiz bBiz = null;
	private QuestionKnowledgeBiz qkBiz = null;
	@Override
	public QuestionFeedBack getSingleQuestionFeedBack(String questionId)
			throws Exception {
		log.info("getSingleQuestionFeedBack questionId:" + questionId);
		if(questionId == null || questionId.equals("")){
			throw new BOException("a03201", "/remark/questionid/"
					+ questionId + ".json");
		}
		QuestionFeedBack qFeedBack = new QuestionFeedBack();
		QuestionJson questionJson = null;
		StudentJson sinfo = null;
		TeacherJson tinfo = null;
		List<QuestionAnalysisAnswer> analysises = null;
		QuestionRemark remark = null;
		List<QuestionKnowledge> qKnowledges = null;
		try {
			factory = BizFactory.newInstance();
			qaaBiz = factory.getQuestionAnalysisAnswerBiz();
			questionJson = getQuestion(questionId);
			if (questionJson == null) {
				throw new BOException("a03201", "/remark/questionid/"
						+ questionId + ".json");
			}
			log.info("学生用戶名：" + questionJson.studentUserName);
			sinfo = getStudentInfo(questionJson.studentUserName);
			analysises = qaaBiz.getQuestionAnalysisAnswerByQuestionId(Long
					.valueOf(questionId));
			String teacherId = getTeacherId(analysises);
			tinfo = getTeacherInfo(teacherId);
			remark = getRemark(String.valueOf(questionJson.id));
			qKnowledges = getQuestionKnowledge(questionId);
			qFeedBack.question = questionJson;
			qFeedBack.analysises = analysises;
			qFeedBack.student = sinfo;
			qFeedBack.teacher = tinfo;
			qFeedBack.remark = remark;
			qFeedBack.knowledges = qKnowledges;
			ReflectUtil.reflect(qFeedBack);
		} catch (BOException boe) {
			log.error("", boe);
			throw boe;
		} catch (Exception e) {
			log.error("方法  getQuestionFeedBack 出现异常......", e);
			throw e;
		}
		return qFeedBack;
	}
	public List<QuestionKnowledge> getQuestionKnowledge(String questionId) throws Exception{
		List<QuestionKnowledge> questionKnowledgeList = null;
		String name = "";
		try {
			factory = BizFactory.newInstance();
			bBiz = factory.getBaseInfoBiz();
			qkBiz = factory.getQuestionKnowledgeBiz();
			questionKnowledgeList = qkBiz.getQuestionKnowledge(questionId);
			for(QuestionKnowledge qk : questionKnowledgeList){
				name =bBiz.getBaseInfo("KNOWLEDGE", qk.getCode());
				log.info("getQuestionKnowledge   name = "+name);
				qk.setName(name);
			}
		} catch (Exception e) {
			log.error("", e);
			throw e;
		}
		return questionKnowledgeList;
	}
	/**
	 * 根据试题ID获取试题信息
	 *
	 * @param questionId
	 * @return
	 * @throws Exception
	 */
	public QuestionJson getQuestion(String questionId) throws Exception {
		Question question = null;
		QuestionJson qJson = null;
		try {
			factory = BizFactory.newInstance();
			qBiz = factory.getQuestionBiz();
			bBiz = factory.getBaseInfoBiz();
			question = qBiz.getQuestion(Long.valueOf(questionId));
			if (question != null) {
				qJson = new QuestionJson();
				qJson = (QuestionJson) BeanUtil.getPOToVO(qJson, question);
				log.info("bookCode = "+qJson.bookCode);
				qJson.bookName = bBiz.getBaseInfo("BOOK", qJson.bookCode);
				qJson.chapterName = bBiz.getBaseInfo("CHAPTER",
						qJson.chapterCode);
				qJson.gradeName = bBiz.getBaseInfo("GRADE", qJson.gradeCode);
				qJson.partName = bBiz.getBaseInfo("PART", qJson.partCode);
				qJson.schoolStageName = bBiz.getBaseInfo("SCHOOL_STAGE",
						qJson.schoolStageCode);
				qJson.subjectName = bBiz.getBaseInfo("SUBJECT",
						qJson.subjectCode);
				log.info(qJson.bookName+"-"+qJson.chapterName+"-"+qJson.gradeName+"-"+qJson.partName+"-"+qJson.schoolStageName+"-"+qJson.subjectName);
			}
		}  catch (BOException boe) {
			log.error("", boe);
			throw boe;
		} catch (Exception e) {
			log.error("方法  getQuestionFeedBack 出现异常......", e);
			throw e;
		}
		return qJson;
	}

	/**
	 * 根据试题编号获取反馈信息
	 *
	 * @param questionId
	 * @return
	 * @throws Exception
	 */
	public QuestionRemark getRemark(String questionId) throws Exception {
		log.info("getRemark questionId:" + questionId);
		QuestionRemark remark = null;
		try {
			factory = BizFactory.newInstance();
			rBiz = factory.getRemarkBiz();
			remark = rBiz.getRemark(questionId);
		} catch (BOException boe) {
			log.error("", boe);
			throw boe;
		} catch (Exception e) {
			log.error("方法  getRemark 出现异常......", e);
			throw e;
		}
		return remark;
	}

	/**
	 * 获取学生信息
	 *
	 * @return
	 * @throws Exception
	 */
	public StudentJson getStudentInfo(String studentId) throws Exception {
		log.info("getStudentInfo studentId:" + studentId);
		StudentInfo stuInfo = null;
		StudentJson student = null;
		StudentController sc = new StudentController();
		try {
			stuInfo = sc.getStudentInfo(studentId);
			if(stuInfo != null){
				student = new StudentJson();
				student = (StudentJson) BeanUtil.getPOToVO(student, stuInfo);
				student.tel = student.username;
			}
		} catch (Exception e) {
			log.error("", e);
		}
		return student;
	}

	/**
	 * 获取老师信息
	 *
	 * @return
	 * @throws Exception
	 */
	public TeacherJson getTeacherInfo(String teacherId) throws Exception {
		log.info("getTeacherInfo teacherId:" + teacherId);
		TeacherInfo teaInfo = null;
		TeacherJson teaJson = null;
		TeacherController tc = new TeacherController();
		try {
			teaInfo = tc.getTeacherInfo(teacherId);
			if(teaInfo != null){
				teaJson = new TeacherJson();
				teaJson = (TeacherJson) BeanUtil.getPOToVO(teaJson, teaInfo);
			}
			ReflectUtil.reflect(teaJson);
		} catch (Exception e) {
			log.error("", e);
		}
		return teaJson;
	}

	/**
	 * 获取老师用户名
	 *
	 * @param analysises
	 * @return
	 * @throws Exception
	 */
	public String getTeacherId(List<QuestionAnalysisAnswer> analysises)
			throws Exception {
		String teacherId = "0";
		try {
			if (analysises != null && analysises.size() > 0){
				for(QuestionAnalysisAnswer qaa:analysises){
					teacherId = qaa.getTeacherUserName();
				}
			}
			log.info("getTeacherId   teacherId="+teacherId);
		} catch (Exception e) {
			log.error("", e);
		}
		return teacherId;
	}
}
