package com.haotiben.feedback.VO;

import java.io.Serializable;

public class TeacherTop implements Serializable {
	private static final long serialVersionUID = 1L;
	public String name;//老师真实名称
	public String userName;//老师用户名
	public int count;//被差评的次数
	public TeacherTop() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}
