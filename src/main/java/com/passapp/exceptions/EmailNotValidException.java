package com.passapp.exceptions;

public class EmailNotValidException extends Exception {

	public EmailNotValidException() {
	}

	public EmailNotValidException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmailNotValidException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmailNotValidException(String message) {
		super(message);
	}

	public EmailNotValidException(Throwable cause) {
		super(cause);
	}
}
