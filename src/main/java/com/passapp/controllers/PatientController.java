package com.passapp.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.passapp.exceptions.PatientNotFoundException;

@RestControllerAdvice
public class PatientController {

	@ExceptionHandler(PatientNotFoundException.class)
	public String patientNotFoundHandler(PatientNotFoundException px) {
		return px.getMessage();
	}
	
}
