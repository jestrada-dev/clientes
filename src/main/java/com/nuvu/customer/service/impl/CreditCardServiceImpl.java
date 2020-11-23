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
	public List<CreditCardEntity> save(List<CreditCardEntity> creditCards) throws Exception {
		return creditCardRepository.saveAll(creditCards);
	}

	@Override
	public boolean delete(CreditCardEntity creditCard) throws Exception {
		creditCardRepository.delete(creditCard);
		return false;
	}


}
