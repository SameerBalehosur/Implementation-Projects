package com.testyantra.tutorial.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Sameer Balehosur
 *
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class ErrorMessages {
	private int statusCode;
	private Date timestamp;
	private String message;
	private String description;
}
