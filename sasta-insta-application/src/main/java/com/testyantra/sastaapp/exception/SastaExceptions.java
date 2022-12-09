package com.testyantra.sastaapp.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class SastaExceptions extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ExceptionHandler(DublicateEmailException.class)
	public ErrorMessages dublicateEmailException(DublicateEmailException exception, WebRequest webRequest) {
		ErrorMessages errorMessages = new ErrorMessages();
		errorMessages.setStatusCode(HttpStatus.NOT_FOUND);
		errorMessages.setMessage(exception.getMessage());
		errorMessages.setDescription(webRequest.getDescription(false));
		errorMessages.setTimestamp(new Date());
		return errorMessages;
	}
	
	@ExceptionHandler(InvalidInputException.class)
	public ErrorMessages invalidInputException(InvalidInputException exception, WebRequest webRequest) {
		ErrorMessages errorMessages = new ErrorMessages();
		errorMessages.setStatusCode(HttpStatus.NOT_FOUND);
		errorMessages.setMessage(exception.getMessage());
		errorMessages.setDescription(webRequest.getDescription(false));
		errorMessages.setTimestamp(new Date());
		return errorMessages;
	}
	
	
	@ExceptionHandler(InvalidUserCredentialsException.class)
	public ErrorMessages invalidcredentialsException(InvalidUserCredentialsException exception, WebRequest webRequest) {
		ErrorMessages errorMessages = new ErrorMessages();
		errorMessages.setStatusCode(HttpStatus.NOT_FOUND);
		errorMessages.setMessage(exception.getMessage());
		errorMessages.setDescription(webRequest.getDescription(false));
		errorMessages.setTimestamp(new Date());
		return errorMessages;
	}

}
