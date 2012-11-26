package com.haotiben.feedback.json;

import java.io.Serializable;

public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;
	public long teacherId;//教师ID
	public String teacherName;//教师姓名
	public String subjectCode;//教师目所属的学科CODE
	public String subjectName;//教师所属的学科的名称
	public String schoolCode;//教师所属的学段的CODE
	public String schoolName;//教师所属的学段的名称
}
