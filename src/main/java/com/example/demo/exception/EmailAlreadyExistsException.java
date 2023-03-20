package com.example.demo.exception;

public class EmailAlreadyExistsException extends Exception {

	private String message;

	public EmailAlreadyExistsException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
