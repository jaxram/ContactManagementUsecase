package com.usecase.exceptions;

public class ContactNotFoundException extends RuntimeException {

	public ContactNotFoundException(String message) {
		super(message);
	}
	
}
