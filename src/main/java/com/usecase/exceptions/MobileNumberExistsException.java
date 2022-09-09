package com.usecase.exceptions;

public class MobileNumberExistsException extends RuntimeException {

	public MobileNumberExistsException(String message) {
		super(message);
	}
}
