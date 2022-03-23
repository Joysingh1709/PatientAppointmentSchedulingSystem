package com.passapp.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.passapp.exceptions.AdminNotAddedException;
import com.passapp.exceptions.AdminNotDeletedException;
import com.passapp.exceptions.AdminNotFoundException;
import com.passapp.exceptions.AdminNotUpdatedException;
import com.passapp.exceptions.AppointmentNotConfirmException;
import com.passapp.exceptions.AppointmentNotFoundException;
import com.passapp.exceptions.DoctorNotAddedException;
import com.passapp.exceptions.DoctorNotDeletedException;
import com.passapp.exceptions.DoctorNotFoundException;
import com.passapp.exceptions.DoctorNotUpdatedException;
import com.passapp.exceptions.PatientNotAddedException;
import com.passapp.exceptions.PatientNotDeletedException;
import com.passapp.exceptions.PatientNotFoundException;
import com.passapp.exceptions.PatientNotUpdatedException;
import com.passapp.exceptions.ReceptionistNotAddedException;
import com.passapp.exceptions.ReceptionistNotDeletedException;
import com.passapp.exceptions.ReceptionistNotFoundException;
import com.passapp.exceptions.ReceptionistNotUpdatedException;

@RestControllerAdvice
public class ApplicationExceptionControllerAdvice {

	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<Map<String, Object>> AdminNotFoundHandler(AdminNotFoundException adx) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", false);
		res.put("message", adx.getMessage());
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AdminNotAddedException.class)
	public ResponseEntity<Map<String, Object>> AdminNotAddedHandler(AdminNotAddedException anax) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", false);
		res.put("message", anax.getMessage());
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(AdminNotUpdatedException.class)
	public ResponseEntity<Map<String, Object>> AdminNotUpdatedHandler(AdminNotUpdatedException anux) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", false);
		res.put("message", anux.getMessage());
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.NOT_MODIFIED);
	}
	
	@ExceptionHandler(AdminNotDeletedException.class)
	public ResponseEntity<Map<String, Object>> AdminNotDeletedHandler(AdminNotDeletedException andx) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", false);
		res.put("message", andx.getMessage());
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseEntity<Map<String, Object>> doctorNotFoundHandler(DoctorNotFoundException dx) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", false);
		res.put("message", dx.getMessage());
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DoctorNotAddedException.class)
	public ResponseEntity<Map<String, Object>> DoctorNotAddedHandler(DoctorNotAddedException dnax) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", false);
		res.put("message", dnax.getMessage());
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(DoctorNotUpdatedException.class)
	public ResponseEntity<Map<String, Object>> DoctorNotUpdatedHandler(DoctorNotUpdatedException dnux) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", false);
		res.put("message", dnux.getMessage());
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.NOT_MODIFIED);
	}
	
	@ExceptionHandler(DoctorNotDeletedException.class)
	public ResponseEntity<Map<String, Object>> DoctorNotDeletedHandler(DoctorNotDeletedException dndx) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", false);
		res.put("message", dndx.getMessage());
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<Map<String, Object>> patientNotFoundHandler(PatientNotFoundException px) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", false);
		res.put("message", px.getMessage());
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PatientNotAddedException.class)
	public ResponseEntity<Map<String, Object>> PatientNotAddedHandler(PatientNotAddedException pnax) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", false);
		res.put("message", pnax.getMessage());
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(PatientNotUpdatedException.class)
	public ResponseEntity<Map<String, Object>> PatientNotUpdatedHandler(PatientNotUpdatedException pnux) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", false);
		res.put("message", pnux.getMessage());
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.NOT_MODIFIED);
	}
	
	@ExceptionHandler(PatientNotDeletedException.class)
	public ResponseEntity<Map<String, Object>> PatientNotDeletedHandler(PatientNotDeletedException pndx) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", false);
		res.put("message", pndx.getMessage());
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	
	@ExceptionHandler(ReceptionistNotFoundException.class)
	public ResponseEntity<Map<String, Object>> ReceptionistNotFoundHandler(ReceptionistNotFoundException rx) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", false);
		res.put("message", rx.getMessage());
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(ReceptionistNotAddedException.class)
	public ResponseEntity<Map<String, Object>> ReceptionistNotAddedHandler(ReceptionistNotAddedException rnax) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", false);
		res.put("message", rnax.getMessage());
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(ReceptionistNotUpdatedException.class)
	public ResponseEntity<Map<String, Object>> ReceptionistNotUpdatedHandler(ReceptionistNotUpdatedException rnux) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", false);
		res.put("message", rnux.getMessage());
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.NOT_MODIFIED);
	}
	
	@ExceptionHandler(ReceptionistNotDeletedException.class)
	public ResponseEntity<Map<String, Object>> ReceptionistNotDeletedHandler(ReceptionistNotDeletedException rndx) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", false);
		res.put("message", rndx.getMessage());
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	@ExceptionHandler(AppointmentNotFoundException.class)
	public ResponseEntity<Map<String, Object>> AppointmentNotFoundHandler(AppointmentNotFoundException apx) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", false);
		res.put("message", apx.getMessage());
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(AppointmentNotConfirmException.class)
	public ResponseEntity<Map<String, Object>> AppointmentNotConfirmHanldler(AppointmentNotConfirmException ax) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", false);
		res.put("message", ax.getMessage());
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.NOT_ACCEPTABLE);
	}

}
