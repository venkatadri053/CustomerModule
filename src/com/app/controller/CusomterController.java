package com.app.controller;

import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.app.model.Customer;
import com.app.service.ICustomerService;
import com.app.util.CustomerUtil;

@Controller
public class CusomterController {

	@Autowired
	private ICustomerService service;
	@Autowired
	private CustomerUtil util;
	@Autowired
	private ServletContext context;



	@RequestMapping("/regCust")
	public String showPage(){
		System.out.println("hello");
		return "CustomerReg";
	}
	@RequestMapping(value="/insertCust",method=RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer")Customer cust, ModelMap map){
		int custId=service.saveCustomer(cust);
		String message="Saved with"+custId;
		map.addAttribute("msg",message);
		return "CustomerReg";
	}

	@RequestMapping("/viewAllCusts")
	public String getAllCusts(ModelMap map){
		List<Customer> cust=service.getAllCustomers();
		map.addAttribute("customers", cust);
		return "CustomerData";
	}
	@RequestMapping("/deleteCust")
	public String deleteCustomer(@RequestParam("custId")int custId){
		service.deleteCustomer(custId);
		return "redirect:viewAllCusts";
	}

	@RequestMapping("/editCust")
	public String CustEdit(@RequestParam("custId")int custId,ModelMap map){
		Customer cust=service.getCustomerById(custId);
		map.addAttribute("cust", cust);
		return "CustomerDataEdit";
	}

	@RequestMapping(value="/updateCust",method=RequestMethod.POST)
	public String updateCustomer(@ModelAttribute("customer")Customer cust){
		service.updateCustomer(cust);
		return "redirect:viewAllCusts";
	}
	/* 7. This method is used to ExcelExport*/
	@RequestMapping("/custExcelExport")
	public String showExcelData(ModelMap map){
		List<Customer> custs=service.getAllCustomers();
		map.addAttribute("custs",custs);
		return "custExcelView";
	}

	/* 8.Location PDF Data export*/ 
	@RequestMapping("/custPdfExport")
	public String PdfData(ModelMap map){
		List<Customer> custs=service.getAllCustomers();
		map.addAttribute("custs",custs);
		return "custPdfView";
	}

	/* 9. Report Design*/
	@RequestMapping("/showCustReports")
	public String generateReports(){
		List<Object[]> list=service.getCustomerTypeCount();
		String path=context.getRealPath("/");
		util.generatePieChart(path, list);
		util.generateBarChart(path, list);
		return "CustomerReports";
	}


}
