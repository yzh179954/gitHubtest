package com.haotiben.feedback.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.haotiben.feedback.VO.TeacherTop;

public class TeacherFeedBackTop implements Serializable {
	private static final long serialVersionUID = 1L;
	public List<TeacherTop> teacherTop = new ArrayList<TeacherTop>();
	public TeacherFeedBackTop() {
		super();
	}
	public List<TeacherTop> getTeacherTop() {
		return teacherTop;
	}
	public void setTeacherTop(List<TeacherTop> teacherTop) {
		this.teacherTop = teacherTop;
	}
}
