package com.passapp.exceptions;

public class ReceptionistNotFoundException extends Exception{
	String message;
	Long receptionistId;
	public ReceptionistNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	public ReceptionistNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public ReceptionistNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public ReceptionistNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public ReceptionistNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public ReceptionistNotFoundException(Long receptionistId) {
		super("Receptionist not found with id ---"+receptionistId);
		// TODO Auto-generated constructor stub
	}

}
