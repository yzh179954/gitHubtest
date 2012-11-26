package com.haotiben.feedback.model;

import java.io.Serializable;

public class SearchValue implements Serializable {
	private static final long serialVersionUID = 1L;
	public String schoolStageCode;
	public String subjectCode;
	public String studentUserName;
	public String teacherUserName;
	public int remarkType;
	public int pageCount;
	public SearchValue() {
		super();
	}
}
