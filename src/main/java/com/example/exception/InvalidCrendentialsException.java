package com.example.exception;

public class InvalidCrendentialsException extends RuntimeException {

	public InvalidCrendentialsException() {
		super("Invalid email or password");
	}
}
