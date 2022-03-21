package com.passapp.exceptions;

public class AppointmentNotFoundException extends Exception{
	String message;
	Long appointmentId;
	public AppointmentNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	public AppointmentNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public AppointmentNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public AppointmentNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public AppointmentNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public AppointmentNotFoundException(Long appointmentId) {
		super("Appointment not found with id ---"+appointmentId);
		// TODO Auto-generated constructor stub
	}

}
