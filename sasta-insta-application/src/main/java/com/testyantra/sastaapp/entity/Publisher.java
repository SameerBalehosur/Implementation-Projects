package com.testyantra.sastaapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * @author Sameer Balehosur
 *
 * 
 */
@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "publisher")
@Builder
@JsonInclude(value = Include.NON_DEFAULT)
public class Publisher implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "publisherId")
	private long publisherId;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	@Email(message = "Please provide valid Email")
	private String email;
	@Column(name = "phoneNumber")
	private String phoneNumber;
	@Column(name = "password")
	private String password;
	@Column(name = "status")
	private String status = "Active";
	
	private long userId;
	
	@Column(name = "approvePost")
	private String approvePost;
	@Column(name = "rejectedPost")
	private String rejectedPost;
	
//	@Column(name = "description")
//	private String description;
//	@Column(name = "post")
//	private String post;
//	@Column(name = "title")
//	private String title;
	
	
}
