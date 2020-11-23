package com.nuvu.customer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nuvu.customer.entity.CustomerEntity;
import com.nuvu.customer.model.GeneralResponse;
import com.nuvu.customer.service.CustomerService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	public static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;	

	/**
	 * List customers.
	 * 
	 * @return 
	 */
	@ApiOperation(value = "List customers.", response = ResponseEntity.class)
	@GetMapping
	public ResponseEntity<GeneralResponse<List<CustomerEntity>>> get() {
		
		GeneralResponse<List<CustomerEntity>> response = new GeneralResponse<>();
		HttpStatus status = null;
		List<CustomerEntity> data = null; 

		try {

			data = customerService.get();
			String msg = "It found " + data.size() + " customers.";
			
			response.setMessage(msg);
			response.setSuccess(true);
			response.setData(data);
			status = HttpStatus.OK;
			
		} catch (Exception e) {
			
			String msg = "Something has failed. Please contact suuport.";
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setMessage(msg);
			response.setSuccess(false);
			
			String log = "End point GET/customers has failed. " + e.getLocalizedMessage();			
			logger.error(log);
		}

		return new ResponseEntity<>(response, status);
	}
	
	/**
	 * 
	 * @param customers
	 * @return
	 */
	@ApiOperation(value = "Add customers.", response = ResponseEntity.class)
	@PostMapping
	public ResponseEntity<GeneralResponse<List<CustomerEntity>>> save(@RequestBody List<CustomerEntity> customers) {
		
		GeneralResponse<List<CustomerEntity>> response = new GeneralResponse<>();
		HttpStatus status = null;
		List<CustomerEntity> data = null; 

		try {

			data = customerService.save(customers);
			String msg = "It Save " + data.size() + " customers.";
			
			response.setMessage(msg);
			response.setSuccess(true);
			response.setData(data);
			status = HttpStatus.OK;
			
		} catch (Exception e) {
			
			String msg = "Something has failed. Please contact suuport.";
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setMessage(msg);
			response.setSuccess(false);
			
			String log = "End point POST/customers has failed. " + e.getLocalizedMessage();			
			logger.error(log);
		}

		return new ResponseEntity<>(response, status);
	}
	
	/**
	 * 
	 * @param customers
	 * @return
	 */
	@ApiOperation(value = "Update customers", response = ResponseEntity.class)
	@PutMapping
	public ResponseEntity<GeneralResponse<List<CustomerEntity>>> update(@RequestBody List<CustomerEntity> customers) {
		
		GeneralResponse<List<CustomerEntity>> response = new GeneralResponse<>();
		HttpStatus status = null;
		List<CustomerEntity> data = null; 

		try {

			data = customerService.save(customers);
			String msg = "It update " + data.size() + " customers.";
			
			response.setMessage(msg);
			response.setSuccess(true);
			response.setData(data);
			status = HttpStatus.OK;
			
		} catch (Exception e) {
			
			String msg = "Something has failed. Please contact suuport.";
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setMessage(msg);
			response.setSuccess(false);
			
			String log = "End point PUT/customers has failed. " + e.getLocalizedMessage();			
			logger.error(log);
		}

		return new ResponseEntity<>(response, status);
	}
	
	/**
	 * 
	 * @param customer
	 * @return
	 */
	@ApiOperation(value = "Delete customer.", response = ResponseEntity.class)
	@DeleteMapping
	public ResponseEntity<GeneralResponse<CustomerEntity>> delete(@RequestBody CustomerEntity customer) {
		
		GeneralResponse<CustomerEntity> response = new GeneralResponse<>();
		HttpStatus status = null;

		try {

			customerService.delete(customer);
			String msg = "Customer deleted by Id " + customer.getId() + ".";
			
			response.setMessage(msg);
			response.setSuccess(true);
			response.setData(customer);
			status = HttpStatus.OK;
			
		} catch (Exception e) {
			
			String msg = "Something has failed. Please contact suuport.";
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setMessage(msg);
			response.setSuccess(false);
			
			String log = "End point DEL/customer has failed. " + e.getLocalizedMessage();			
			logger.error(log);
		}

		return new ResponseEntity<>(response, status);
	}
}
