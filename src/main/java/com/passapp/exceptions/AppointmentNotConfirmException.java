package com.passapp.exceptions;

public class AppointmentNotConfirmException extends Exception {
	
	String message;
	Long appointmentId;
	public AppointmentNotConfirmException() {
		// TODO Auto-generated constructor stub
	}
	public AppointmentNotConfirmException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public AppointmentNotConfirmException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public AppointmentNotConfirmException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public AppointmentNotConfirmException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public AppointmentNotConfirmException(Long appointmentId) {
		super("Appointment not confirmed for id ---"+ appointmentId);
		// TODO Auto-generated constructor stub
	}

}
