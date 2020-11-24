package com.nuvu.customer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nuvu.customer.entity.UserEntity;
import com.nuvu.customer.model.GeneralResponse;
import com.nuvu.customer.service.UserService;
import com.nuvu.customer.util.JwtUtils;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {
	
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwtUtils;

	/**
	 * Login with userName and password.
	 * 
	 * @param user
	 * @return
	 */
	@ApiOperation(value = "Login width userName and password", response = ResponseEntity.class)
	@PostMapping("/auth")
	public ResponseEntity<GeneralResponse<UserEntity>> login(@RequestBody UserEntity user) {
		
		GeneralResponse<UserEntity> response = new GeneralResponse<>();
		HttpStatus status = null;

		try {
			
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword())
					);
			user.setJwt(jwtUtils.generateToken(user.getUserName()));
			
			user.setPassword(null);
			String msg = "Login successfull for user " + user.getUserName() + ".";
			
			response.setMessage(msg);
			response.setSuccess(true);
			response.setData(user);
			status = HttpStatus.OK;
			
		} catch (AuthenticationException e) {
			
			String msg = "Usuario o clave incorrectos.";
			status = HttpStatus.FORBIDDEN;
			response.setMessage(msg);
			response.setSuccess(false);
			
			String log = msg + e.getLocalizedMessage();			
			logger.error(log);		
		
		} catch (Exception e) {
			
			String msg = "Something has failed. Please contact suuport.";
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setMessage(msg);
			response.setSuccess(false);
			
			String log = "End point POST/users/auth has failed. " + e.getLocalizedMessage();			
			logger.error(log);
		}

		return new ResponseEntity<>(response, status);
	}


	/**
	 * List users.
	 * 
	 * @return @List<UserVO>
	 */
	@ApiOperation(value = "List users.", response = ResponseEntity.class)
	@GetMapping
	public ResponseEntity<GeneralResponse<List<UserEntity>>> get() {
		
		GeneralResponse<List<UserEntity>> response = new GeneralResponse<>();
		HttpStatus status = null;
		List<UserEntity> data = null; 

		try {

			data = userService.get();
			String msg = "It found " + data.size() + " users.";
			
			response.setMessage(msg);
			response.setSuccess(true);
			response.setData(data);
			status = HttpStatus.OK;
			
		} catch (Exception e) {
			
			String msg = "Something has failed. Please contact suuport.";
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setMessage(msg);
			response.setSuccess(false);
			
			String log = "End point GET/user has failed. " + e.getLocalizedMessage();			
			logger.error(log);
		}

		return new ResponseEntity<>(response, status);
	}
	
	/**
	 * Save users.
	 * 
	 * @return @List<UserVO>
	 */
	@ApiOperation(value = "Add users.", response = ResponseEntity.class)
	@PostMapping
	public ResponseEntity<GeneralResponse<List<UserEntity>>> save(@RequestBody List<UserEntity> users) {
		
		GeneralResponse<List<UserEntity>> response = new GeneralResponse<>();
		HttpStatus status = null;
		List<UserEntity> data = null; 

		try {

			data = userService.save(users);
			String msg = "It Save " + data.size() + " users.";
			
			response.setMessage(msg);
			response.setSuccess(true);
			response.setData(data);
			status = HttpStatus.OK;
			
		} catch (Exception e) {
			
			String msg = "Something has failed. Please contact suuport.";
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setMessage(msg);
			response.setSuccess(false);
			
			String log = "End point POST/user has failed. " + e.getLocalizedMessage();			
			logger.error(log);
		}

		return new ResponseEntity<>(response, status);
	}
	
	/**
	 * Update users.
	 * 
	 * @return @List<UserVO>
	 */
	@ApiOperation(value = "Update users", response = ResponseEntity.class)
	@PutMapping
	public ResponseEntity<GeneralResponse<List<UserEntity>>> update(@RequestBody List<UserEntity> users) {
		
		GeneralResponse<List<UserEntity>> response = new GeneralResponse<>();
		HttpStatus status = null;
		List<UserEntity> data = null; 

		try {

			data = userService.save(users);
			String msg = "It update " + data.size() + " users.";
			
			response.setMessage(msg);
			response.setSuccess(true);
			response.setData(data);
			status = HttpStatus.OK;
			
		} catch (Exception e) {
			
			String msg = "Something has failed. Please contact suuport.";
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setMessage(msg);
			response.setSuccess(false);
			
			String log = "End point PUT/users has failed. " + e.getLocalizedMessage();			
			logger.error(log);
		}

		return new ResponseEntity<>(response, status);
	}
	
	/**
	 * Delete user.
	 * 
	 * @return @List<UserVO>
	 */
	@ApiOperation(value = "Delete user.", response = ResponseEntity.class)
	@DeleteMapping("/{userName}")
	public ResponseEntity<GeneralResponse<String>> delete(@PathVariable String userName) {
		
		GeneralResponse<String> response = new GeneralResponse<>();
		HttpStatus status = null;

		try {

			userService.delete(userName);
			String msg = "It delete by user " + userName + ".";
			
			response.setMessage(msg);
			response.setSuccess(true);
			response.setData(userName);
			status = HttpStatus.OK;
			
		} catch (Exception e) {
			
			String msg = "Something has failed. Please contact suuport.";
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setMessage(msg);
			response.setSuccess(false);
			
			String log = "End point GET/user has failed. " + e.getLocalizedMessage();			
			logger.error(log);
		}

		return new ResponseEntity<>(response, status);
	}
}
