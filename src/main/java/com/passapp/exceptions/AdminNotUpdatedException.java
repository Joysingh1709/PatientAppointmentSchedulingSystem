package com.passapp.exceptions;

public class AdminNotUpdatedException extends Exception{
	String message;
	Long adminId;
	public AdminNotUpdatedException() {
		// TODO Auto-generated constructor stub
	}
	public AdminNotUpdatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public AdminNotUpdatedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public AdminNotUpdatedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public AdminNotUpdatedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public AdminNotUpdatedException(Long adminId) {
		super("Admin not updated with id ---"+adminId);
		// TODO Auto-generated constructor stub
	}

}
