package com.testyantra.flipkart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testyantra.flipkart.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
