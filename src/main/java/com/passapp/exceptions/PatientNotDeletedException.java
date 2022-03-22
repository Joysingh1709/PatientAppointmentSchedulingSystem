package com.passapp.exceptions;

public class PatientNotDeletedException extends Exception{
	String message;
	Long userId;
	public PatientNotDeletedException() {
		// TODO Auto-generated constructor stub
	}
	public PatientNotDeletedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public PatientNotDeletedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public PatientNotDeletedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public PatientNotDeletedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public PatientNotDeletedException(Long userId) {
		super("Patient not deleted with id ---"+ userId);
		// TODO Auto-generated constructor stub
	}
}
