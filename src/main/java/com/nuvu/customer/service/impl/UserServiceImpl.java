package com.nuvu.customer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nuvu.customer.entity.UserEntity;
import com.nuvu.customer.repository.UserRepository;
import com.nuvu.customer.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<UserEntity> get() throws Exception {
		return userRepository.findAll();
	}

	@Override
	public List<UserEntity> save(List<UserEntity> users) throws Exception {
		for (UserEntity userVO : users) {
			userRepository.save(userVO);
		}
		return users;
	}

	@Override
	public boolean delete(UserEntity user) throws Exception {
		userRepository.deleteById(user.getUserName());
		return true;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserEntity userVO = userRepository.findByUserName(userName);
		UserDetails userDetails = new User(userVO.getUserName(), userVO.getPassword(), new ArrayList<>());
		
		return userDetails;
	}
	


}
