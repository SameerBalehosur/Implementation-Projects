package com.testyantra.cob.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.testyantra.cob.constants.CustomerConstants;
import com.testyantra.cob.dto.CustomerRequest;
import com.testyantra.cob.dto.CustomerResponse;
import com.testyantra.cob.model.Customer;
import com.testyantra.cob.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	public CustomerResponse customerRegistration(CustomerRequest customerRequest) {
		if (!ObjectUtils.isEmpty(customerRequest)) {
			Customer customer = new Customer();
			BeanUtils.copyProperties(customerRequest, customer);
			customerRepository.save(customer);
			log.info("Customer Registration success {}", customerRequest);
			return CustomerResponse.builder().statusCode(CustomerConstants.SUCESS_STATUS_CODE)
					.statusDesc(CustomerConstants.SUCESS_STATUS_DESC)
					.message(CustomerConstants.REGISTRATION_MESSGAE_SUCCESS).build();
		}
		log.error("Input Datas {} are null ", customerRequest);
		return CustomerResponse.builder().statusCode(CustomerConstants.FAIL_STATUS_CODE)
				.statusDesc(CustomerConstants.FAIL_STATUS_DESC).message(CustomerConstants.REGISTRATION_MESSGAE_FAIL)
				.build();
	}

	public CustomerResponse customerLogin(CustomerRequest customerRequest) {
		if (!ObjectUtils.isEmpty(customerRequest)) {
			Customer customer = new Customer();
			BeanUtils.copyProperties(customerRequest, customer);
			if (customerRepository.existsById(customer.getCustomerId())) {
				Customer referenceById = customerRepository.getReferenceById(customer.getCustomerId());
				if (referenceById.getPassword().equalsIgnoreCase(customer.getPassword())) {
					return CustomerResponse.builder().statusCode(CustomerConstants.SUCESS_STATUS_CODE)
							.statusDesc(CustomerConstants.SUCESS_STATUS_DESC).message(CustomerConstants.LOGIN_SUCCESS)
							.customer(referenceById).build();
				}
				else {
					log.error("password incorrect ", customerRequest);
					return CustomerResponse.builder().statusCode(CustomerConstants.FAIL_STATUS_CODE)
							.statusDesc(CustomerConstants.FAIL_STATUS_DESC).message(CustomerConstants.REGISTRATION_MESSGAE_FAIL)
							.build();
				}
			}
			else {
				log.error("User not found", customerRequest);
				return CustomerResponse.builder().statusCode(CustomerConstants.FAIL_STATUS_CODE)
						.statusDesc(CustomerConstants.FAIL_STATUS_DESC).message(CustomerConstants.REGISTRATION_MESSGAE_FAIL)
						.build();
			}
		}
		else {
			return CustomerResponse.builder().statusCode(CustomerConstants.FAIL_STATUS_CODE)
					.statusDesc(CustomerConstants.FAIL_STATUS_DESC).message(CustomerConstants.REGISTRATION_MESSGAE_FAIL)
					.build();
		}

	}
}
