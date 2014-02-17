package com.haotiben.feedback.VO;

import java.io.Serializable;
import java.util.Date;


public class SearchValue implements Serializable {
	private static final long serialVersionUID = 1L;
	public String schoolStageCode;
	public String subjectCode;
	public String studentUserName;
	public String teacherUserName;
	public String questionType;
	public int remarkType;
	public int pageCount;//当前页码
	public String order;// 正反序
	public String sortBy;// 属性名称
	public int pageSize = 3;//默认一页显示记录数
	public String datebegin;
	public String dateend;
	public SearchValue() {
		super();
	}
}
