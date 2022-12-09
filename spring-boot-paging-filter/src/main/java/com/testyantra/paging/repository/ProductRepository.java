package com.testyantra.paging.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testyantra.paging.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
