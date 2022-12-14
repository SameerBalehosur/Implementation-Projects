package com.testyantra.paging.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tutorials")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tutorial {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "published")
	private boolean published;
	
	public Tutorial(String title, String description, boolean published) {
	    this.title = title;
	    this.description = description;
	    this.published = published;
	  }
}
