package com.testyantra.paging.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testyantra.paging.model.Product;
import com.testyantra.paging.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@Operation(description = "This API is used to Get all product details")
	@GetMapping("/getall")
	public List<Product> findAllProducts() {
		return productService.findAllProducts();
	}

	@GetMapping("/getWithSorting/{field}")
	public List<Product> findProductsWithSorting(@PathVariable String field) {
		return productService.findProductsWithSorting(field);
	}

	@GetMapping("/getWithPagination/{offset}/{pageSize}")
	public Page<Product> findProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
		return productService.findProductsWithPagination(offset, pageSize);
	}

	@GetMapping("/getWithSortingAndPaging/{offset}/{pageSize}/{field}")
	public Page<Product> findProductsWithPaginationAndSorting(@PathVariable int offset, @PathVariable int pageSize,
			@PathVariable String field) {
		return productService.findProductsWithPaginationAndSorting(offset, pageSize, field);
	}

	@GetMapping("/getReports/{reportFormat}")
	public String getReports(String reportFormat) throws FileNotFoundException, JRException {
		return productService.exportReposrts(reportFormat);

	}

}
