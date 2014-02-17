package com.haotiben.feedback.model;

import java.io.Serializable;
import java.util.Date;

public class Remark implements Serializable {
	private static final long serialVersionUID = 1L;
	public long questionId;
	public String imageUrl;
	public String studentUserName;
	public String teacherUserName;
	public int remarkType;
	public Date remarkTime;
	public String remark;
	public String subject;
	public Date questionUpTime;
	public Date questionResolveTime;
	public Date questionFetchTime;
	public Remark() {
		super();
	}
}
