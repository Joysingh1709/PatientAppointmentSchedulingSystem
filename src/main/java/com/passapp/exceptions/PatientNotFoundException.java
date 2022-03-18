package com.passapp.exceptions;

public class PatientNotFoundException extends Exception {
	String message;
	Long userId;
	public PatientNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	public PatientNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public PatientNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public PatientNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public PatientNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public PatientNotFoundException(Long userId) {
		super("Patient not found with id ---"+ userId);
		// TODO Auto-generated constructor stub
	}
}