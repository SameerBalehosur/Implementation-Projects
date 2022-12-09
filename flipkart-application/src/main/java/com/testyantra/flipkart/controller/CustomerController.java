package com.testyantra.flipkart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testyantra.flipkart.response.CustomerResponse;
import com.testyantra.flipkart.service.CustomerServiceImpl;

/**
 * @author Sameer Balehosur
 *
 * 
 */
@RestController
@RequestMapping("/apis/flipkart/customer")
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl customerServiceImpl;
	
	@GetMapping("/customerDetaisls")
	public ResponseEntity<?> customerDetails(@RequestParam Integer customerId) {
		if(customerId!=null) {
			CustomerResponse customerDetails = customerServiceImpl.customerDetails(customerId);
			if(customerDetails!=null) {
				return new ResponseEntity<>(customerDetails,HttpStatus.OK);
			}return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}

}
