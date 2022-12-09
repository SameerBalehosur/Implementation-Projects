package com.testyantra.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testyantra.batch.entity.Customer;
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
