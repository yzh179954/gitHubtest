package com.haotiben.feedback.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.haotiben.feedback.model.Subject;

public class Subjects implements Serializable {
	private static final long serialVersionUID = 1L;
	public List<Subject> subjects = new ArrayList<Subject>();
	public Subjects() {
		super();
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

}
