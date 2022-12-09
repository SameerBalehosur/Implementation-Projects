package com.testyantra.flipkart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Builder
@Data
@JsonInclude(value = Include.NON_DEFAULT)
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int orderId;
	private String orderName;
	private String referenceNo;
	private String orderDetails;
	private String status;

}
