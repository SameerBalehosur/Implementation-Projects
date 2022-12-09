package com.testyantra.cob.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(value = Include.NON_DEFAULT)
public class CustomerRequest {
	private int customerId;
	private String name;
	private String gender;
	private String branch;
	private long accountNo;
	private String password;
	private String status="INACTIVE";
}
