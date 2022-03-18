package com.passapp.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.passapp.exceptions.AppointmentNotConfirmException;
import com.passapp.exceptions.DoctorNotFoundException;
import com.passapp.exceptions.PatientNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionControllerAdvice {

	@ExceptionHandler(PatientNotFoundException.class)
	public String patientNotFoundHandler(PatientNotFoundException px) {
		return px.getMessage();
	}
	
	@ExceptionHandler(DoctorNotFoundException.class)
	public String doctorNotFoundHandler(DoctorNotFoundException dx) {
		return dx.getMessage();
	}
	
	@ExceptionHandler(AppointmentNotConfirmException.class)
	public String AppointmentNotConfirmHaldler(AppointmentNotConfirmException ax) {
		return ax.getMessage();
	}

}
