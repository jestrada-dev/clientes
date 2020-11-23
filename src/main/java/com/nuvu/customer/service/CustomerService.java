package com.nuvu.customer.service;

import java.util.List;

import com.nuvu.customer.entity.CustomerEntity;

public interface CustomerService {

	public List<CustomerEntity> get() throws Exception;
	
	public List<CustomerEntity> save(List<CustomerEntity> customers) throws Exception;
	
	public boolean delete(CustomerEntity customer) throws Exception;
		
}
