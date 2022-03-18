package com.passapp.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.passapp.exceptions.AppointmentNotConfirmException;

@RestControllerAdvice
public class AppointmentController {
	
	@ExceptionHandler(AppointmentNotConfirmException.class)
	public String AppointmentNotConfirmHaldler(AppointmentNotConfirmException ax) {
		return ax.getMessage();
	}

}
