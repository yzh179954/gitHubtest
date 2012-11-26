package com.haotiben.feedback.json;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	public long studentId;//学生ID
	public String studentName;//学生姓名
	public String subjectCode;//学生上传的题目所属的学科CODE
	public String subjectName;//学生上传的题目所属的学科的名称
	public String schoolCode;//学生上传的题目所属的学段的CODE
	public String schoolName;//学生上传的题目所属的学段的名称
	public String tel;//学生电话
}
