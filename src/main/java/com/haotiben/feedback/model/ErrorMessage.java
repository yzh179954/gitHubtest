package com.haotiben.feedback.model;


public class ErrorMessage {
	public String request;// 请求URL地址
	public String errorCode;// 状态码
	public String error;// 描述

	public ErrorMessage() {
		super();
	}

	public ErrorMessage(String request, String errorCode, String error) {
		super();
		this.request = request;
		this.errorCode = errorCode;
		this.error = error;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
