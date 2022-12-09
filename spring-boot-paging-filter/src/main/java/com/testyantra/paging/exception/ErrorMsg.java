package com.testyantra.paging.exception;
/**
 * @author Sameer Balehosur
 *
 */

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorMsg {
	private HttpStatus statusCode;
	private Date timestamp;
	private String message;
	private String description; 
}
