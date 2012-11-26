package com.haotiben.feedback.VO;

public class TeacherInfo {

	private Long id;
	private String csn;
	private String username;
	private String password;
	private String realName;
	private String email;
	private String mobile;
	private String stage;
	private String grade;
	private String subject;
	private String disable;
	private String status;
	private String statusCode;

	public TeacherInfo() {
	}

	public TeacherInfo(Long id, String csn, String username, String password,
			String realName, String email, String mobile, String stage,
			String grade, String subject, String disable, String status,
			String statusCode) {
		super();
		this.id = id;
		this.csn = csn;
		this.username = username;
		this.password = password;
		this.realName = realName;
		this.email = email;
		this.mobile = mobile;
		this.stage = stage;
		this.grade = grade;
		this.subject = subject;
		this.disable = disable;
		this.status = status;
		this.statusCode = statusCode;
	}

	public String getCsn() {
		return csn;
	}

	public void setCsn(String csn) {
		this.csn = csn;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDisable() {
		return disable;
	}

	public void setDisable(String disable) {
		this.disable = disable;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

}