package com.clothing.sarees.service;

import java.util.List;

import com.clothing.sarees.dao.CustomerDao;
import com.clothing.sarees.model.customer;
public class CustomerService {

	private static CustomerDao CustomerDao;

	public CustomerService() {
		CustomerDao = new CustomerDao();
	}

	public void persist(customer entity) {
		CustomerDao.openCurrentSessionwithTransaction();
		CustomerDao.persist(entity);
		CustomerDao.closeCurrentSessionwithTransaction();
	}

	public void update(customer entity) {
		CustomerDao.openCurrentSessionwithTransaction();
		CustomerDao.update(entity);
		CustomerDao.closeCurrentSessionwithTransaction();
	}

	public customer findById(int id) {
		CustomerDao.openCurrentSession();
		customer customer = CustomerDao.findById(id);
		CustomerDao.closeCurrentSession();
		return customer;
	}

	public void delete(int id) {
		CustomerDao.openCurrentSessionwithTransaction();
		customer customer = CustomerDao.findById(id);
		CustomerDao.delete(customer);
		CustomerDao.closeCurrentSessionwithTransaction();
	}

	public List<customer> findAll() {
		CustomerDao.openCurrentSession();
		List<customer> customers = CustomerDao.findAll();
		CustomerDao.closeCurrentSession();
		return customers;
	}

	public void deleteAll() {
		CustomerDao.openCurrentSessionwithTransaction();
		CustomerDao.deleteAll();
		CustomerDao.closeCurrentSessionwithTransaction();
	}

	
}
