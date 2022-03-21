package com.passapp.exceptions;

public class AdminNotFoundException extends Exception{
	String message;
	Long adminId;
	public AdminNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	public AdminNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public AdminNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public AdminNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public AdminNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public AdminNotFoundException(Long adminId) {
		super("Admin not found with id ---"+adminId);
		// TODO Auto-generated constructor stub
	}


}
