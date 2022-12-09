package com.testyantra.mongodb.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sameer
 *
 */
@Data
@Builder
@Document(collection = "cricketers")
@AllArgsConstructor
@NoArgsConstructor
public class Cricketers {

	@Id
	private int id;
	private String name;
	private String city;
	private int jourseyNo;
	private BigDecimal income;
	private String nickName;
}
