package com.testyantra.cob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testyantra.cob.dto.CustomerRequest;
import com.testyantra.cob.dto.CustomerResponse;
import com.testyantra.cob.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@PostMapping("/registration")
	public CustomerResponse customerRegistration(@Validated @RequestBody CustomerRequest customerRequest) {
		return customerService.customerRegistration(customerRequest);
	}
	
	@PostMapping("/login")
	public CustomerResponse customerLogin(@Validated @RequestBody CustomerRequest customerReq) {
		return customerService.customerLogin(customerReq);
	}
	
}
