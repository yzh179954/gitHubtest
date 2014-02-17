package com.haotiben.feedback.json;

import java.io.Serializable;

public class TeacherJson implements Serializable {
	private static final long serialVersionUID = 1L;
	public String realName;
	private String mobile;
	public String username;
	public TeacherJson() {
		super();
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
