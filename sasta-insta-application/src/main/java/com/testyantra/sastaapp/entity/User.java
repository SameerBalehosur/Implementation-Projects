package com.testyantra.sastaapp.entity;

import java.util.List;

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
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "user")
@Builder
@Data
@JsonInclude(value = Include.NON_ABSENT)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "userId")
	private long userId;
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
	@OneToMany(mappedBy = "user")
	@JsonManagedReference
	List<Posts> listOfPosts;
}
