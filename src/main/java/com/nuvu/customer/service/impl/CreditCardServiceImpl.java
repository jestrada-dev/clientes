package com.nuvu.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuvu.customer.entity.CreditCardEntity;
import com.nuvu.customer.repository.CreditCardRepository;
import com.nuvu.customer.service.CreditCardService;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	CreditCardRepository creditCardRepository;

	@Override
	public List<CreditCardEntity> get() throws Exception {
		return creditCardRepository.findAll();
	}

	@Override
	public CreditCardEntity save(CreditCardEntity creditCard) throws Exception {
		return creditCardRepository.save(creditCard);
	}

	@Override
	public boolean delete(String number) throws Exception {
		creditCardRepository.deleteById(number);
		return true;
	}


}
