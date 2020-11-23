package com.nuvu.customer.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMERS")
public class CustomerEntity {

	@Id
	private BigDecimal id;
	private String docType;
	@Column(unique = true)
	private String docId;
	private String lastName;
	private String firstName;
	
    @OneToMany(mappedBy = "customer")
	private List<CreditCardEntity> creditCards;
	
	private String email;
	
	public CustomerEntity() {
	}

	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<CreditCardEntity> getCreditCards() {
		return creditCards;
	}
	public void setCreditCards(List<CreditCardEntity> creditCards) {
		this.creditCards = creditCards;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
