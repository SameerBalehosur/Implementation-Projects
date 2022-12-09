package com.testyantra.flipkart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testyantra.flipkart.entity.Customer;
import com.testyantra.flipkart.repository.CustomerRepo;
import com.testyantra.flipkart.response.CustomerResponse;

@Service
public class CustomerServiceImpl {

	@Autowired
	CustomerRepo customerRepo;

	public CustomerResponse customerDetails(Integer customerId) {
		try {
			if (customerId!=0) {
				Customer customerDetails = customerRepo.findById(customerId)
						.orElseThrow();
				if (customerDetails != null) {
					return	CustomerResponse.builder().customerDetails(customerDetails).build();
				}
			}
		} catch (Exception e) {
		}

		return CustomerResponse.builder().msg("Something is Wrong !!!!!!!!!").build();

	}

}
