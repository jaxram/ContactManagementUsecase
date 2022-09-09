package com.usecase.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler
	public ResponseEntity<ErrorObject> handleMobileNumberExistsException(MobileNumberExistsException exc)
	{
		ErrorObject errobj= new ErrorObject();
		errobj.setStatusCode(HttpStatus.CONFLICT.value());
		errobj.setMessage(exc.getMessage());
		errobj.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ErrorObject>(errobj, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorObject> handleContactNo0tFoundException(ContactNotFoundException exc)
	{
		ErrorObject errobj= new ErrorObject();
		errobj.setStatusCode(HttpStatus.NOT_FOUND.value());
		errobj.setMessage(exc.getMessage());
		errobj.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ErrorObject>(errobj, HttpStatus.NOT_FOUND);
	}

}
