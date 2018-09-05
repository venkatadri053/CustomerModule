package com.app.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
import com.app.service.ICustomerService;
@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerDao dao;

	@Override
	public int saveCustomer(Customer cust) {
		return dao.saveCustomer(cust);
	}

	@Override
	public void updateCustomer(Customer cust) {
		dao.updateCutomer(cust);
	}
	@Override
	public void deleteCustomer(int custId) {
		dao.deleteCustomer(custId);
	}

	@Override
	public Customer getCustomerById(int custId) {
		return dao.getCustomerById(custId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> custs=	dao.getAllCustomers();
		Collections.sort(custs, new Comparator<Customer>() {
			public int compare(Customer obj1, Customer obj2) {
				return obj1.getCustId()-obj2.getCustId();

			}
		});
		return custs;
	}

	@Override
	public List<Object[]> getCustomerTypeCount() {
		return dao.getCustomerTypeCount();
	}


}
