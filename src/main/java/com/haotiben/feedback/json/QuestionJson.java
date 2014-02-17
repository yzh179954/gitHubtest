package com.haotiben.feedback.json;

import java.io.Serializable;
import java.util.Date;

public class QuestionJson implements Serializable {
	private static final long serialVersionUID = 1L;
	public long id;
	public String schoolStageCode;
	public String schoolStageName;
	public String gradeCode;
	public String gradeName;
	public String subjectCode;
	public String subjectName;
	public String bookCode;
	public String bookName;
	public String chapterCode;
	public String chapterName;
	public String partCode;
	public String partName;
	public String studentUserName;
	public String imageUrl;
	public String questionDesc;
	public String teacherMobile;
	public String help;
	public String status;
	public String voiceStatus;
	public int isDel;
	public Date completeAt;
	public Date clientAt;
	public Date createAt;
	public QuestionJson() {
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
	public String getSchoolStageName() {
		return schoolStageName;
	}
	public void setSchoolStageName(String schoolStageName) {
		this.schoolStageName = schoolStageName;
	}
	public String getGradeCode() {
		return gradeCode;
	}
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getChapterCode() {
		return chapterCode;
	}
	public void setChapterCode(String chapterCode) {
		this.chapterCode = chapterCode;
	}
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	public String getPartCode() {
		return partCode;
	}
	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
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
