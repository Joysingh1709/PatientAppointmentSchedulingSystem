package com.passapp.exceptions;

public class  PatientNotAddedException extends Exception {
	String message;
	Long userId;
	public PatientNotAddedException() {
		// TODO Auto-generated constructor stub
	}
	public PatientNotAddedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public PatientNotAddedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public PatientNotAddedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public PatientNotAddedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public PatientNotAddedException(Long userId) {
		super("Patient not added with id ---"+ userId);
		// TODO Auto-generated constructor stub
	}

}
