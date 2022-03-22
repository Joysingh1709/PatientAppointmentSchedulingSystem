package com.passapp.exceptions;

public class AdminNotAddedException extends Exception{
	String message;
	Long adminId;
	public AdminNotAddedException() {
		// TODO Auto-generated constructor stub
	}
	public AdminNotAddedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public AdminNotAddedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public AdminNotAddedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public AdminNotAddedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public AdminNotAddedException(	Long adminId) {
		super("Admin not added with id ---"+adminId);
		// TODO Auto-generated constructor stub
	}
}
