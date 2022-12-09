package com.testyantra.cob.dto;

import java.util.List;

import com.testyantra.cob.model.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse  {
	private String statusCode;
	private String statusDesc;
	private String message;
	private Customer customer;
//	List<E>

}
