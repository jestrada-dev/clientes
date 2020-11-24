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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nuvu.customer.entity.CreditCardEntity;
import com.nuvu.customer.model.GeneralResponse;
import com.nuvu.customer.service.CreditCardService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/credit-cards")
public class CreditCardController {
	
	public static final Logger logger = LoggerFactory.getLogger(CreditCardController.class);

	@Autowired
	private CreditCardService creditCardService;	


	/**
	 * List credit cards
	 * 
	 * @return
	 */
	@ApiOperation(value = "List credit cards.", response = ResponseEntity.class)
	@GetMapping
	public ResponseEntity<GeneralResponse<List<CreditCardEntity>>> get() {
		
		GeneralResponse<List<CreditCardEntity>> response = new GeneralResponse<>();
		HttpStatus status = null;
		List<CreditCardEntity> data = null; 

		try {

			data = creditCardService.get();
			String msg = "It found " + data.size() + " credit cards.";
			
			response.setMessage(msg);
			response.setSuccess(true);
			response.setData(data);
			status = HttpStatus.OK;
			
		} catch (Exception e) {
			
			String msg = "Something has failed. Please contact suuport.";
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setMessage(msg);
			response.setSuccess(false);
			
			String log = "End point GET/credit-cards has failed. " + e.getLocalizedMessage();			
			logger.error(log);
		}

		return new ResponseEntity<>(response, status);
	}
	
	/**
	 * List credit cards By Customer id
	 * 
	 * @return
	 */
	@ApiOperation(value = "List credit cards by Customer id.", response = ResponseEntity.class)
	@GetMapping("/customer-id/{customerId}")
	public ResponseEntity<GeneralResponse<List<CreditCardEntity>>> get(@PathVariable Integer customerId) {
		
		GeneralResponse<List<CreditCardEntity>> response = new GeneralResponse<>();
		HttpStatus status = null;
		List<CreditCardEntity> data = null; 

		try {

			data = creditCardService.getByCustomerId(customerId);
			String msg = "It found " + data.size() + " credit cards.";
			
			response.setMessage(msg);
			response.setSuccess(true);
			response.setData(data);
			status = HttpStatus.OK;
			
		} catch (Exception e) {
			
			String msg = "Something has failed. Please contact suuport.";
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setMessage(msg);
			response.setSuccess(false);
			
			String log = "End point GET/credit-cards/customer has failed. " + e.getLocalizedMessage();			
			logger.error(log);
		}

		return new ResponseEntity<>(response, status);
	}
	
	/**
	 * Add credit card.
	 * 
	 * @param creditCard
	 * @return
	 */
	@ApiOperation(value = "Add credit card.", response = ResponseEntity.class)
	@PostMapping
	public ResponseEntity<GeneralResponse<CreditCardEntity>> save(@RequestBody CreditCardEntity creditCard) {
		
		GeneralResponse<CreditCardEntity> response = new GeneralResponse<>();
		HttpStatus status = null;
		CreditCardEntity data = null; 

		try {

			data = creditCardService.save(creditCard);
			String msg = "It Save credit card number *****" + data.getNumber().substring(12, 16) + ".";
			
			response.setMessage(msg);
			response.setSuccess(true);
			response.setData(data);
			status = HttpStatus.OK;
			
		} catch (Exception e) {
			
			String msg = "Something has failed. Please contact suuport.";
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setMessage(msg);
			response.setSuccess(false);
			
			String log = "End point POST/credit-cards has failed. " + e.getLocalizedMessage();			
			logger.error(log);
		}

		return new ResponseEntity<>(response, status);
	}
	
	/**
	 * Update credit card
	 * 
	 * @param creditCard
	 * @return
	 */
	@ApiOperation(value = "Update credit card", response = ResponseEntity.class)
	@PutMapping
	public ResponseEntity<GeneralResponse<CreditCardEntity>> update(@RequestBody CreditCardEntity creditCard) {
		
		GeneralResponse<CreditCardEntity> response = new GeneralResponse<>();
		HttpStatus status = null;
		CreditCardEntity data = null; 

		try {

			data = creditCardService.save(creditCard);
			String msg = "It update credit card number *****" + data.getNumber().substring(12, 16) + ".";
			
			response.setMessage(msg);
			response.setSuccess(true);
			response.setData(data);
			status = HttpStatus.OK;
			
		} catch (Exception e) {
			
			String msg = "Something has failed. Please contact suuport.";
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setMessage(msg);
			response.setSuccess(false);
			
			String log = "End point PUT/credit-cards has failed. " + e.getLocalizedMessage();			
			logger.error(log);
		}

		return new ResponseEntity<>(response, status);
	}
	
	/**
	 * Delete credit card
	 * 
	 * @param creditCard
	 * @return
	 */
	@ApiOperation(value = "Delete credit card.", response = ResponseEntity.class)
	@DeleteMapping("/{number}")
	public ResponseEntity<GeneralResponse<String>> delete(@PathVariable String number) {
		
		GeneralResponse<String> response = new GeneralResponse<>();
		HttpStatus status = null;

		try {

			creditCardService.delete(number);
			String msg = "Credit card deleted by number ****" + number.substring(12, 16) + ".";
			
			response.setMessage(msg);
			response.setSuccess(true);
			response.setData(number);
			status = HttpStatus.OK;
			
		} catch (Exception e) {
			
			String msg = "Something has failed. Please contact suuport.";
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setMessage(msg);
			response.setSuccess(false);
			
			String log = "End point DEL/credit-cards has failed. " + e.getLocalizedMessage();			
			logger.error(log);
		}

		return new ResponseEntity<>(response, status);
	}
}
