package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.app.model.Customer;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class CustomerPdfView extends AbstractPdfView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document,PdfWriter pw,
			HttpServletRequest req, HttpServletResponse res)throws Exception {
		
		//to specify filename&download
		res.addHeader("Content-Disposition", "attachment;filename=CUSTOMERS.pdf");
		
		//reading data
		List<Customer> custs=(List<Customer>)map.get("custs");
		//creating paragraph
		Paragraph p=new Paragraph("WELCOME TO CUSTOMERS PDF FILE!!!");
		//creating table
		PdfPTable table=new PdfPTable(7);
		//creating header row
		table.addCell(" ID");
		table.addCell(" NAME");
		table.addCell(" EMAIL");
		table.addCell(" TYPE");
		table.addCell(" ADDRESS");
		table.addCell(" PASSWORD");
		table.addCell(" TOKEN");
		
		//adding data as body
		for(Customer cust:custs){
			table.addCell(cust.getCustId()+"");
			table.addCell(cust.getCustName());
			table.addCell(cust.getCustEmail());
			table.addCell(cust.getCustType());
			table.addCell(cust.getCustAddr());
			table.addCell(cust.getPassword());
			table.addCell(cust.getAccToken());
		}

		//adding elements to PDF Document.
		document.add(p);
		document.add(table);
		document.add(new Paragraph(new Date().toString()));
	}


}
