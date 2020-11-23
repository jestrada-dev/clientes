package com.nuvu.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nuvu.customer.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
	
	UserEntity findByUserName(String userName);

}
