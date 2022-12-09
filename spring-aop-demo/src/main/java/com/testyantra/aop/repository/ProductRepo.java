package com.testyantra.aop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testyantra.aop.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

}
