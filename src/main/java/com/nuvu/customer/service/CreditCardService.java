package com.nuvu.customer.service;

import java.util.List;

import com.nuvu.customer.entity.CreditCardEntity;

public interface CreditCardService {

	public List<CreditCardEntity> get() throws Exception;
	
	public List<CreditCardEntity> getByCustomerId(Integer customerId) throws Exception;
	
	public CreditCardEntity save(CreditCardEntity creditCard) throws Exception;
	
	public boolean delete(String number) throws Exception;
		
}
