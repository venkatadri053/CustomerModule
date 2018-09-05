package com.app.view;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Customer;

public class CustomerExcelView extends AbstractExcelView {
	@Override
	protected void buildExcelDocument(Map<String, Object> map,HSSFWorkbook book,
			HttpServletRequest req, HttpServletResponse res)throws Exception {

		//to specify filename&download
		res.addHeader("Content-Disposition", "attachment;filename=CUSTOMERS.xls");
		//read data from map
		@SuppressWarnings("unchecked")
		List<Customer> custs=(List<Customer>)map.get("custs");
		//create Sheet
		HSSFSheet sheet=book.createSheet("CUSTS");
		//set header
		setHead(sheet);
		//set body
		setBody(sheet, custs);

	}
	public void setHead(HSSFSheet sheet){
		int rowNum=0;
		HSSFRow row=sheet.createRow(rowNum);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("NAME");
		row.createCell(2).setCellValue("EMAIL");
		row.createCell(3).setCellValue("TYPE");
		row.createCell(4).setCellValue("ADDRESS");
		row.createCell(5).setCellValue("PASSWORD");
		row.createCell(6).setCellValue("TOKEN");
	}
	public void setBody(HSSFSheet sheet,List<Customer> custs){
		int rowNum=1;
		for(Customer cust:custs){
			HSSFRow row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(cust.getCustId());
			row.createCell(1).setCellValue(cust.getCustName());
			row.createCell(2).setCellValue(cust.getCustEmail());
			row.createCell(3).setCellValue(cust.getCustType());
			row.createCell(4).setCellValue(cust.getCustAddr());
			row.createCell(5).setCellValue(cust.getPassword());
			row.createCell(6).setCellValue(cust.getAccToken());
		}
	}

}



