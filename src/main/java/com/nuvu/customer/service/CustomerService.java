package com.nuvu.customer.service;

import java.util.List;

import com.nuvu.customer.entity.CustomerEntity;

public interface CustomerService {

	public List<CustomerEntity> get() throws Exception;
	
	public CustomerEntity save(CustomerEntity customer) throws Exception;
	
	public boolean delete(Integer id) throws Exception;
		
}
