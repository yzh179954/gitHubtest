package com.haotiben.feedback.model;

import java.io.Serializable;
import java.util.Date;

public class Question implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String schoolStageCode;
	private String gradeCode;
	private String subjectCode;
	private String bookCode;
	private String chapterCode;
	private String partCode;
	private String studentUserName;
	private String imageUrl;
	private String questionDesc;
	private String teacherMobile;
	private String help;
	private String status;
	private String voiceStatus;
	private int isDel;
	private Date completeAt;
	private Date clientAt;
	private Date createAt;
	public Question() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSchoolStageCode() {
		return schoolStageCode;
	}
	public void setSchoolStageCode(String schoolStageCode) {
		this.schoolStageCode = schoolStageCode;
	}
	public String getGradeCode() {
		return gradeCode;
	}
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getChapterCode() {
		return chapterCode;
	}
	public void setChapterCode(String chapterCode) {
		this.chapterCode = chapterCode;
	}
	public String getPartCode() {
		return partCode;
	}
	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}
	public String getStudentUserName() {
		return studentUserName;
	}
	public void setStudentUserName(String studentUserName) {
		this.studentUserName = studentUserName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getQuestionDesc() {
		return questionDesc;
	}
	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}
	public String getTeacherMobile() {
		return teacherMobile;
	}
	public void setTeacherMobile(String teacherMobile) {
		this.teacherMobile = teacherMobile;
	}
	public String getHelp() {
		return help;
	}
	public void setHelp(String help) {
		this.help = help;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getVoiceStatus() {
		return voiceStatus;
	}
	public void setVoiceStatus(String voiceStatus) {
		this.voiceStatus = voiceStatus;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public Date getCompleteAt() {
		return completeAt;
	}
	public void setCompleteAt(Date completeAt) {
		this.completeAt = completeAt;
	}
	public Date getClientAt() {
		return clientAt;
	}
	public void setClientAt(Date clientAt) {
		this.clientAt = clientAt;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

}
