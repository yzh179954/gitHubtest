package com.haotiben.feedback.json;

import java.io.Serializable;

public class TeacherJson implements Serializable {
	private static final long serialVersionUID = 1L;
	public long teacherId;//教师ID
	public String teacherName;//教师姓名
	public String realName;
	public TeacherJson() {
		super();
	}
	public long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}

}
