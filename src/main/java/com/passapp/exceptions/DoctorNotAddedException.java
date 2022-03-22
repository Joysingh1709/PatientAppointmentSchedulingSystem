package com.passapp.exceptions;

public class DoctorNotAddedException extends Exception{

	String message;
	Long doctorId;
	public DoctorNotAddedException() {
		// TODO Auto-generated constructor stub
	}
	public DoctorNotAddedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public DoctorNotAddedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public DoctorNotAddedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public DoctorNotAddedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public DoctorNotAddedException(Long doctorId) {
		super("Doctor not added with id ---"+doctorId);
		// TODO Auto-generated constructor stub
	}
}