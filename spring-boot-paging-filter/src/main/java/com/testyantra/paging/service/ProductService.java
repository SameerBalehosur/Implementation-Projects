package com.testyantra.paging.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.testyantra.paging.exception.EmptyDataException;
import com.testyantra.paging.exception.InvalidInputDataException;
import com.testyantra.paging.model.Product;
import com.testyantra.paging.repository.ProductRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
//For Inserting the default data to db
//    @PostConstruct
//    public void initDB() {
//        List<Product> products = IntStream.rangeClosed(1, 200)
//                .mapToObj(i -> new Product("product" + i, new Random().nextInt(100), new Random().nextInt(50000)))
//                .collect(Collectors.toList());
//        repository.saveAll(products);
//    }

	public List<Product> findAllProducts() {
		List<Product> findAll = repository.findAll();
		if(!findAll.isEmpty()) {
			return findAll;
		}else {
			throw new EmptyDataException("The List is Empty");
		}
	}

	public List<Product> findProductsWithSorting(String field) {
		if(field.equalsIgnoreCase("id") || field.equalsIgnoreCase("name") ||  field.equalsIgnoreCase("price") ||  field.equalsIgnoreCase("quantity")) {
			return repository.findAll(Sort.by(Sort.Direction.ASC, field));
		}else {
			throw new InvalidInputDataException("Invalid Input Sorting Alogorithm !!");
		}
	}

	public Page<Product> findProductsWithPagination(int offset, int pageSize) {
		
		return repository.findAll(PageRequest.of(offset, pageSize));
	}

	public Page<Product> findProductsWithPaginationAndSorting(int offset, int pageSize, String field) {
		return repository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
	}

	public String exportReposrts(String reportFormat) throws FileNotFoundException, JRException {
		String path = "C:\\Users\\samee\\OneDrive\\Desktop\\jasperreports";

		List<Product> products = repository.findAll();
		File file = ResourceUtils.getFile("classpath:products.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(products);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("CreatedBY", "Sameer Balehosur");
		JasperPrint fillReport = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		if (reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(path + "\\products.html");
		}
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(path + "\\\\products.pdf");
		}
		return "Reporte generated Success To : " + path;

	}
}
