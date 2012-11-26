package com.haotiben.feedback.controller.client;

import org.apache.log4j.Logger;

import com.haotiben.feedback.VO.StudentInfo;
import com.haotiben.feedback.common.Resource;
import com.haotiben.feedback.common.StringUtil;
import com.sun.jersey.api.client.ClientResponse;

public class StudentController {
	final static String url = Resource.getString("oauth");
	private static Logger log = Logger.getLogger(StudentController.class);
	/**
	 * 从oauth系统获取学生详细信息
	 * @return
	 * @throws Exception
	 */
	public StudentInfo getStudentInfo(String studentId)throws Exception{
		StudentInfo sinfo = new StudentInfo();
		try {
			ClientResponse response = StringUtil.getWebResource(url+"user.json?username="+studentId+"").get(
					ClientResponse.class);
			StudentInfo studentInfo = response.getEntity(StudentInfo.class);
			System.out.println("-------------"+studentInfo.getParent_email());
		} catch (Exception e) {
			log.error("", e);
		}
		return sinfo;
	}
	public static void main(String[] args) {
		StudentController sc = new StudentController();
		try {
			sc.getStudentInfo("test");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
