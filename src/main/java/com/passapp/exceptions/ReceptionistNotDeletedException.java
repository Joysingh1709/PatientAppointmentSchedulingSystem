package com.passapp.exceptions;

public class ReceptionistNotDeletedException extends Exception{
	String message;
	Long receptionistId;
	public ReceptionistNotDeletedException() {
		// TODO Auto-generated constructor stub
	}
	public ReceptionistNotDeletedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public ReceptionistNotDeletedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public ReceptionistNotDeletedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public ReceptionistNotDeletedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public ReceptionistNotDeletedException(Long receptionistId) {
		super("Receptionist not deleted with id ---"+receptionistId);
		// TODO Auto-generated constructor stub
	}

}
