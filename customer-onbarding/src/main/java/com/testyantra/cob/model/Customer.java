package com.testyantra.cob.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Builder
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_DEFAULT)
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	@Column(name = "name", length = 30, nullable = false,unique = true)
	private String name;
	@Column(name = "branch", length = 30, nullable = false)
	private String branch;
	@Column(name = "accountNo", length = 30, nullable = false,unique = true)
	private long accountNo;
	@Column(name = "gender", length = 30, nullable = false)
	private String gender;
	private String status="INACTIVE";
	@Column(name = "password", length = 30, nullable = false)
	private String password;
	

}
