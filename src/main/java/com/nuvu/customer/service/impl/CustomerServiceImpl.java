package com.nuvu.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuvu.customer.entity.CustomerEntity;
import com.nuvu.customer.repository.CustomerRepository;
import com.nuvu.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<CustomerEntity> get() throws Exception {
		return customerRepository.findAll();
	}

	@Override
	public List<CustomerEntity> save(List<CustomerEntity> customers) throws Exception {
		return customerRepository.saveAll(customers);
	}

	@Override
	public boolean delete(CustomerEntity customer) throws Exception {
		customerRepository.delete(customer);
		return false;
	}
	


}
