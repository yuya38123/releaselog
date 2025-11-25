package com.example.exception;

public class EmailAlreadyUsedException extends RuntimeException {

	public EmailAlreadyUsedException(String email) {
		super("email already in use:" + email);
	}
}
