package com.nuvu.customer.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuvu.customer.entity.CreditCardEntity;
import com.nuvu.customer.repository.CreditCardRepository;
import com.nuvu.customer.service.CreditCardService;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	CreditCardRepository creditCardRepository;

	@PersistenceContext
	EntityManager entityManager;
	
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

	@Override
	public List<CreditCardEntity> getByCustomerId(Integer customerId) throws Exception {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CreditCardEntity> query = builder.createQuery(CreditCardEntity.class);
		Root<CreditCardEntity> filtro = query.from(CreditCardEntity.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (!Objects.isNull(customerId)) {
			predicates.add(builder.equal(filtro.get("customer").get("id"), customerId));			
		}
		query.orderBy(builder.asc(filtro.get("number")));
		query.select(filtro).where(predicates.toArray(new Predicate[] {}));
		return entityManager.createQuery(query).getResultList();
	}


}
