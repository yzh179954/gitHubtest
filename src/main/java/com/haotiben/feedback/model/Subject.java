package com.haotiben.feedback.model;

import java.io.Serializable;

public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String code;
	private String name;
	private int is_del;
	public Subject() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIs_del() {
		return is_del;
	}
	public void setIs_del(int is_del) {
		this.is_del = is_del;
	}

}
