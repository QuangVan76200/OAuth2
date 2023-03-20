package com.example.demo.exception;

import io.jsonwebtoken.io.IOException;

public class UploadFileException extends IOException {

	private String message;

	public UploadFileException(String message) {
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
