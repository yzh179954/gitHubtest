package com.haotiben.feedback.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.haotiben.feedback.model.Remark;

public class FeedBack implements Serializable {
	private static final long serialVersionUID = 1L;
	public List<Remark> remarks = new ArrayList<Remark>();
}
