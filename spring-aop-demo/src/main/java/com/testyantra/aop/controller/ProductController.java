package com.testyantra.aop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testyantra.aop.model.Product;
import com.testyantra.aop.service.ProductService;

@RestController
@RequestMapping("/api/v1/")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("upload/")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		String addproduct = productService.addproduct(product);
		if (!addproduct.isEmpty()) {
			return new ResponseEntity(addproduct, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/getall")
	public ResponseEntity<Product> getAllProducts() {
		List<Product> allProducts = productService.getAllProducts();
		if (!allProducts.isEmpty()) {
			return new ResponseEntity(allProducts, HttpStatus.OK);

		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
