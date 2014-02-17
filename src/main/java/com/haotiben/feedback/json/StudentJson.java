package com.haotiben.feedback.json;

import java.io.Serializable;

public class StudentJson implements Serializable {
	private static final long serialVersionUID = 1L;
	public String username;//学生姓名
	public String student_name;//真是TMD姓名
	public String tel;//学生电话
	public StudentJson() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

}
