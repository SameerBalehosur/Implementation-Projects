package com.testyantra.aop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testyantra.aop.model.Product;
import com.testyantra.aop.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo productRepo;

	public String addproduct(Product product) {
		try {
			if (product != null) {
				Product save = productRepo.save(product);
				if (save!=null) {
					return "Product Added";
				} else {
					return "Something went wrong!!!";
				}
			} else {
				throw new IllegalAccessException("Wrong");
			}
		} catch (Exception e) {

		}

		return null;

	}
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

}
