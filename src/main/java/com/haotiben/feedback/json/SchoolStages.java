package com.haotiben.feedback.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.haotiben.feedback.model.SchoolStage;

public class SchoolStages implements Serializable {
	private static final long serialVersionUID = 1L;
	public List<SchoolStage> stages = new ArrayList<SchoolStage>();
	public SchoolStages() {
		super();
	}
	public List<SchoolStage> getStages() {
		return stages;
	}
	public void setStages(List<SchoolStage> stages) {
		this.stages = stages;
	}

}
