package com.testyantra.sastaapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "posts")
@Builder
@Data
@JsonInclude(value = Include.NON_DEFAULT)
public class Posts {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long postId;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name = "post")
	private String post;
	private String status;
	@ManyToOne
	@JsonBackReference
	User user;
	@ManyToOne
	Publisher publisher;

}
