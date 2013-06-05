package com.haotiben.feedback.util;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExportExcelTest extends HttpServlet{


public void doGet(HttpServletRequest request,HttpServletResponse response) {
	response.setContentType("octets/stream");
	response.addHeader("Content-Disposition",
            "attachment;filename=test.xls");


//	 String[] excelHeader = { "Sno", "Name", "Age"};
//	 public HSSFWorkbook export(List list){
//	HSSFWorkbook hwb = null;
//	  HSSFSheet sheet = hwb.createSheet("Campaign");
//	  HSSFRow row = sheet.createRow((int) 0);
//	  HSSFCellStyle style = hwb.createCellStyle();
//	  style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//
//
//	  for (int i = 0; i < excelHeader.length; i++) {
//          HSSFCell cell = row.createCell(i);
//          cell.setCellValue(excelHeader[i]);
//          cell.setCellStyle(style);
//          sheet.autoSizeColumn(i);
//      }
//	  for (int i = 0; i < list.size(); i++) {
//          row = sheet.createRow(i + 1);
//          = list.get(i);
//          row.createCell(0).setCellValue(student.getSno());
//          row.createCell(1).setCellValue(student.getName());
//          row.createCell(2).setCellValue(student.getAge());
//      }
//	return hwb;




	 }
}
