package com.app.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.app.dao.ICustomerDao;
import com.app.model.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public int saveCustomer(Customer cust) {
		return (Integer)ht.save(cust);
	}

	@Override
	public void updateCutomer(Customer cust) {
		ht.update(cust);		
	}

	@Override
	public void deleteCustomer(int custId) {
		Customer cust=new Customer(custId);
		ht.delete(cust);
	}

	@Override
	public Customer getCustomerById(int custId) {
		return ht.get(Customer.class, custId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return ht.loadAll(Customer.class);
	}

	@Override
	public List<Object[]> getCustomerTypeCount() {
		String hql="select custType,count(custType) from com.app.model.Customer group by custType";
		@SuppressWarnings("unchecked")
		List<Object[]> list=ht.find(hql);
		return list;
	}

}
