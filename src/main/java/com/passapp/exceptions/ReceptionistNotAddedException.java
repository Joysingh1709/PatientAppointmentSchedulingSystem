package com.passapp.exceptions;

public class ReceptionistNotAddedException extends Exception{

	String message;
	Long receptionistId;
	public ReceptionistNotAddedException() {
		// TODO Auto-generated constructor stub
	}
	public ReceptionistNotAddedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public ReceptionistNotAddedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public ReceptionistNotAddedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public ReceptionistNotAddedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public ReceptionistNotAddedException(Long receptionistId) {
		super("Receptionist not added with id ---"+receptionistId);
		// TODO Auto-generated constructor stub
	}

}
