package com.passapp.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.passapp.exceptions.AppointmentNotConfirmException;
import com.passapp.exceptions.AppointmentNotFoundException;
import com.passapp.exceptions.DoctorNotFoundException;
import com.passapp.exceptions.PatientNotFoundException;
import com.passapp.exceptions.ReceptionistNotFoundException;

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
	public ResponseEntity<Map<String, Object>> doctorNotFoundHandler(DoctorNotFoundException dx) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", false);
		res.put("message", dx.getMessage());
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AppointmentNotConfirmException.class)
	public ResponseEntity<Map<String, Object>> AppointmentNotConfirmHanldler(AppointmentNotConfirmException ax) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", false);
		res.put("message", ax.getMessage());
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.NOT_ACCEPTABLE);
	}

	
	@ExceptionHandler(AppointmentNotFoundException.class)
	public ResponseEntity<Map<String, Object>> AppointmentNotFoundHandler(AppointmentNotFoundException apx) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", false);
		res.put("message", apx.getMessage());
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(ReceptionistNotFoundException.class)
	public ResponseEntity<Map<String, Object>> ReceptionistNotFoundHandler(ReceptionistNotFoundException rx) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", false);
		res.put("message", rx.getMessage());
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.NOT_FOUND);
	}

}
