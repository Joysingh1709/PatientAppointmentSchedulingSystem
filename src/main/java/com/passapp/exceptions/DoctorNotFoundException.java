package com.passapp.exceptions;

public class DoctorNotFoundException extends Exception{
	String message;
	Long doctorId;
	public DoctorNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	public DoctorNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public DoctorNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public DoctorNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public DoctorNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public DoctorNotFoundException(Long doctorId) {
		super("Doctor not found with id ---"+doctorId);
		// TODO Auto-generated constructor stub
	}

}