package com.haotiben.feedback.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.haotiben.feedback.model.Remark;

public class FeedBack implements Serializable {
	private static final long serialVersionUID = 1L;
	public List<Remark> remarks = new ArrayList<Remark>();
	public int total;//总页数
	public int pageSize;//当前页显示记录数
	public int currentPage;//当前页
	public FeedBack() {
		super();
	}
	public List<Remark> getRemarks() {
		return remarks;
	}
	public void setRemarks(List<Remark> remarks) {
		this.remarks = remarks;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}
