package com.passapp.exceptions;

public class PatientNotUpdatedException extends Exception {
	String message;
	Long userId;
	public PatientNotUpdatedException() {
		// TODO Auto-generated constructor stub
	}
	public PatientNotUpdatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public PatientNotUpdatedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public PatientNotUpdatedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public PatientNotUpdatedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public PatientNotUpdatedException(Long userId) {
		super("Patient not updated with id ---"+ userId);
		// TODO Auto-generated constructor stub
	}
}
