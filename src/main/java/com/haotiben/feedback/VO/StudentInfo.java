package com.haotiben.feedback.VO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class StudentInfo {

	private String userid = "";
	private String username = "";
	private String password = "";
	private String telephone = "";
	private int valid = 1;
	private String serial_number = "";
	private String student_email = "";
	private String student_name = "";
	private String nickname = "";
	private String student_sex = "";
	private String student_province = "";
	private String student_city = "";
	private String student_grade = "";
	private String student_school = "";
	private String parent_name = "";
	private String parent_sex = "";
	private String relationship = "";
	private String parent_phone = "";
	private String parent_email = "";
	private List<SubjectBook> student_book = new ArrayList<SubjectBook>();
	private String hardware_code = "";
	private String telephone_list = "";
	private String student_class = "";
	private String id_card = "";
	private String version = "";
	private Date createAt = new Date();
	private String feeType = "A";

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		if (version == null) {
			version = "";
		}
		this.version = version;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		if (userid == null) {
			userid = "";
		}
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if (username == null) {
			username = "";
		}
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password == null) {
			password = "";
		}
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		if (telephone == null) {
			telephone = "";
		}
		this.telephone = telephone;
	}

	public int getValid() {
		return valid;
	}

	public void setValid(int valid) {
		this.valid = valid;
	}

	public String getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(String serial_number) {
		if (serial_number == null) {
			serial_number = "";
		}
		this.serial_number = serial_number;
	}

	public String getStudent_email() {
		return student_email;
	}

	public void setStudent_email(String student_email) {
		if (student_email == null) {
			student_email = "";
		}
		this.student_email = student_email;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		if (student_name == null) {
			student_name = "";
		}
		this.student_name = student_name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		if (nickname == null) {
			nickname = "";
		}
		this.nickname = nickname;
	}

	public String getStudent_sex() {
		return student_sex;
	}

	public void setStudent_sex(String student_sex) {
		if (student_sex == null) {
			student_sex = "";
		}
		this.student_sex = student_sex;
	}

	public String getStudent_province() {
		return student_province;
	}

	public void setStudent_province(String student_province) {
		if (student_province == null) {
			student_province = "";
		}
		this.student_province = student_province;
	}

	public String getStudent_city() {
		return student_city;
	}

	public void setStudent_city(String student_city) {
		if (student_city == null) {
			student_city = "";
		}
		this.student_city = student_city;
	}

	public String getStudent_grade() {
		return student_grade;
	}

	public void setStudent_grade(String student_grade) {
		this.student_grade = student_grade;
	}

	public String getStudent_school() {
		return student_school;
	}

	public void setStudent_school(String student_school) {
		this.student_school = student_school;
	}

	public String getParent_name() {
		return parent_name;
	}

	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}

	public String getParent_sex() {
		return parent_sex;
	}

	public void setParent_sex(String parent_sex) {
		if (parent_sex == null) {
			parent_sex = "";
		}
		this.parent_sex = parent_sex;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		if (relationship == null) {
			relationship = "";
		}
		this.relationship = relationship;
	}

	public String getParent_phone() {
		return parent_phone;
	}

	public void setParent_phone(String parent_phone) {
		if (parent_phone == null) {
			parent_phone = "";
		}
		this.parent_phone = parent_phone;
	}

	public String getParent_email() {
		return parent_email;
	}

	public void setParent_email(String parent_email) {
		if (parent_email == null) {
			parent_email = "";
		}
		this.parent_email = parent_email;
	}

	public List<SubjectBook> getStudent_book() {
		return student_book;
	}

	public void setStudent_book(List<SubjectBook> student_book) {
		if (student_book == null) {
			student_book = new ArrayList<SubjectBook>();
		}
		this.student_book = student_book;
	}

	public String getHardware_code() {
		return hardware_code;
	}

	public void setHardware_code(String hardware_code) {
		if (hardware_code == null) {
			hardware_code = "";
		}
		this.hardware_code = hardware_code;
	}

	public String getTelephone_list() {
		return telephone_list;
	}

	public void setTelephone_list(String telephone_list) {
		if (telephone_list == null) {
			telephone_list = "";
		}
		this.telephone_list = telephone_list;
	}

	public String getStudent_class() {
		return student_class;
	}

	public void setStudent_class(String student_class) {
		if (student_class == null) {
			student_class = "";
		}
		this.student_class = student_class;
	}

	public String getId_card() {
		return id_card;
	}

	public void setId_card(String id_card) {
		if (id_card == null) {
			id_card = "";
		}
		this.id_card = id_card;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

}
