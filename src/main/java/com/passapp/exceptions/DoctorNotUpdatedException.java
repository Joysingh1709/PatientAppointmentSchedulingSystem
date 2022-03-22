package com.passapp.exceptions;

public class DoctorNotUpdatedException extends Exception {

	String message;
	Long doctorId;
	public DoctorNotUpdatedException() {
		// TODO Auto-generated constructor stub
	}
	public DoctorNotUpdatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public DoctorNotUpdatedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public DoctorNotUpdatedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public DoctorNotUpdatedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public DoctorNotUpdatedException(Long doctorId) {
		super("Doctor not updated with id ---"+doctorId);
		// TODO Auto-generated constructor stub
	}

}
