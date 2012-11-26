package com.haotiben.feedback.controller.client;

import org.apache.log4j.Logger;

import com.haotiben.feedback.VO.TeacherInfo;
import com.haotiben.feedback.common.Resource;
import com.haotiben.feedback.common.StringUtil;
import com.sun.jersey.api.client.ClientResponse;

public class TeacherController {
	final static String url = Resource.getString("privilege");
	private static Logger log = Logger.getLogger(StudentController.class);
	public TeacherInfo getTeacherInfo(String teacherId)throws Exception{
		TeacherInfo tinfo = new TeacherInfo();
		try {
			ClientResponse response = StringUtil.getWebResource(url+teacherId+".json").get(
					ClientResponse.class);
			TeacherInfo teacherInfo = response.getEntity(TeacherInfo.class);
			System.out.println("-------------"+teacherInfo.getUsername());
		} catch (Exception e) {
			log.error("", e);
		}
		return tinfo;
	}
	public static void main(String[] args) {
		TeacherController tc = new TeacherController();
		try {
			tc.getTeacherInfo("50");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
