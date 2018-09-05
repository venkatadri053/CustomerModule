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

	
}
