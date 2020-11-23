package com.nuvu.customer.service;

import java.util.List;

import com.nuvu.customer.entity.CreditCardEntity;

public interface CreditCardService {

	public List<CreditCardEntity> get() throws Exception;
	
	public List<CreditCardEntity> save(List<CreditCardEntity> creditCard) throws Exception;
	
	public boolean delete(CreditCardEntity creditCard) throws Exception;
		
}
