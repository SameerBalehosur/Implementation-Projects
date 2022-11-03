package com.testyantra.tutorial.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * @author Sameer Balehosur
 *
 */
@Entity
@Table(name = "tutorials")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tutorial {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tutorial_id")
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "published")
	private boolean published;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	private Comment comment;

}
