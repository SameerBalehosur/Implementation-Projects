package com.testyantra.flipkart.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Sameer Balehosur
 *
 * 
 */
@javax.persistence.Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@javax.persistence.Table(name = "products")
@Builder
@Data
@JsonInclude(value = Include.NON_DEFAULT)
public class Products {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int productId;
	private String productName;
	private int price;
	private String orderDetails;
	private String status;
}
