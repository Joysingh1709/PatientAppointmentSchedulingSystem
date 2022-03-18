package com.passapp.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.passapp.exceptions.AppointmentNotConfirmException;
import com.passapp.exceptions.DoctorNotFoundException;
import com.passapp.exceptions.PatientNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionControllerAdvice {

	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<Map<String, Object>> patientNotFoundHandler(PatientNotFoundException px) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", false);
		res.put("message", px.getMessage());
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.NOT_FOUND);
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
