package com.passapp.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.passapp.exceptions.DoctorNotFoundException;

@RestControllerAdvice
public class DoctorController {

	@ExceptionHandler(DoctorNotFoundException.class)
	public String doctorNotFoundHandler(DoctorNotFoundException dx) {
		return dx.getMessage();
	}
}
