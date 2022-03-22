package com.passapp.exceptions;

public class DoctorNotDeletedException extends Exception {
	String message;
	Long doctorId;
	public DoctorNotDeletedException() {
		// TODO Auto-generated constructor stub
	}
	public DoctorNotDeletedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public DoctorNotDeletedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public DoctorNotDeletedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public DoctorNotDeletedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public DoctorNotDeletedException(Long doctorId) {
		super("Doctor not deleted with id ---"+doctorId);
		// TODO Auto-generated constructor stub
	}
}
