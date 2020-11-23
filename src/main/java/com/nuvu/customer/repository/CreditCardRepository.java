package com.nuvu.customer.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nuvu.customer.entity.CreditCardEntity;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCardEntity, BigDecimal> {
	

}
