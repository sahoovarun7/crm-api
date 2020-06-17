package com.ghostack.webtrackerapi.dao;

import java.util.List;

import com.ghostack.webtrackerapi.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	public void saveCustomer(Customer customer);
	public Customer getCustomer(Integer custID);
	public void deleteCustomer(Integer custID);
	public List<Customer> searchCustomer(String searchName);
}
