package com.passapp.exceptions;

public class AdminNotDeletedException extends Exception{
	String message;
	Long adminId;
	public AdminNotDeletedException() {
		// TODO Auto-generated constructor stub
	}
	public AdminNotDeletedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public AdminNotDeletedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public AdminNotDeletedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public AdminNotDeletedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public AdminNotDeletedException(Long adminId) {
		super("Admin not deleted with id ---"+adminId);
		// TODO Auto-generated constructor stub
	}


}
