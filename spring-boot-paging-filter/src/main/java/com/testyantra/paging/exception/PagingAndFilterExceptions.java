package com.testyantra.paging.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class PagingAndFilterExceptions {

	@ExceptionHandler(EmptyDataException.class)
	public ResponseEntity<ErrorMsg> emptyDataException(EmptyDataException dataException,WebRequest request) {
		ErrorMsg errorMsg=new ErrorMsg();
		errorMsg.setMessage(dataException.getMessage());
		errorMsg.setStatusCode(HttpStatus.NOT_FOUND);
		errorMsg.setTimestamp(new Date());
		errorMsg.setDescription(request.getDescription(false));
		return new ResponseEntity<>(errorMsg,HttpStatus.OK);
	}
	
	@ExceptionHandler(InvalidInputDataException.class)
	public ResponseEntity<ErrorMsg> invalidInputDataException(InvalidInputDataException dataException,WebRequest request) {
		ErrorMsg errorMsg=new ErrorMsg();
		errorMsg.setMessage(dataException.getMessage());
		errorMsg.setStatusCode(HttpStatus.BAD_REQUEST);
		errorMsg.setTimestamp(new Date());
		errorMsg.setDescription(request.getDescription(false));
		return new ResponseEntity<>(errorMsg,HttpStatus.OK);
	}
}
