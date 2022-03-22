package com.passapp.exceptions;

public class ReceptionistNotUpdatedException extends Exception {
	String message;
	Long receptionistId;
	public ReceptionistNotUpdatedException() {
		// TODO Auto-generated constructor stub
	}
	public ReceptionistNotUpdatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public ReceptionistNotUpdatedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public ReceptionistNotUpdatedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public ReceptionistNotUpdatedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public ReceptionistNotUpdatedException(Long receptionistId) {
		super("Receptionist not updated with id ---"+receptionistId);
		// TODO Auto-generated constructor stub
	}

}
