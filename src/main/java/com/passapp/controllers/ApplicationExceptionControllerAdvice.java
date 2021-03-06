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
import com.passapp.exceptions.AppointmentNotDeletedException;
import com.passapp.exceptions.AppointmentNotFoundException;
import com.passapp.exceptions.DoctorNotAddedException;
import com.passapp.exceptions.DoctorNotDeletedException;
import com.passapp.exceptions.DoctorNotFoundException;
import com.passapp.exceptions.DoctorNotUpdatedException;
import com.passapp.exceptions.EmailNotValidException;
import com.passapp.exceptions.PasswordNotValidException;
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

	private static final String status = "status";
	private static final String message = "message";

	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<Map<String, Object>> adminNotFoundHandler(AdminNotFoundException anf) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, anf.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AdminNotAddedException.class)
	public ResponseEntity<Map<String, Object>> adminNotAddedHandler(AdminNotAddedException anax) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, anax.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(AdminNotUpdatedException.class)
	public ResponseEntity<Map<String, Object>> adminNotUpdatedHandler(AdminNotUpdatedException anux) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, anux.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_MODIFIED);
	}

	@ExceptionHandler(AdminNotDeletedException.class)
	public ResponseEntity<Map<String, Object>> adminNotDeletedHandler(AdminNotDeletedException andx) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, andx.getMessage());
		return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(EmailNotValidException.class)
	public ResponseEntity<Map<String, Object>> emailNotValidExceptionHandler(EmailNotValidException envx) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, envx.getMessage());
		return new ResponseEntity<>(res, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(PasswordNotValidException.class)
	public ResponseEntity<Map<String, Object>> passwordNotValidExceptionHandler(PasswordNotValidException pnvx) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, pnvx.getMessage());
		return new ResponseEntity<>(res, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseEntity<Map<String, Object>> doctorNotFoundHandler(DoctorNotFoundException dnfx) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, dnfx.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DoctorNotAddedException.class)
	public ResponseEntity<Map<String, Object>> doctorNotAddedHandler(DoctorNotAddedException dnax) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, dnax.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(DoctorNotUpdatedException.class)
	public ResponseEntity<Map<String, Object>> doctorNotUpdatedHandler(DoctorNotUpdatedException dnux) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, dnux.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_MODIFIED);
	}

	@ExceptionHandler(DoctorNotDeletedException.class)
	public ResponseEntity<Map<String, Object>> doctorNotDeletedHandler(DoctorNotDeletedException dndx) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, dndx.getMessage());
		return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<Map<String, Object>> patientNotFoundHandler(PatientNotFoundException pnfx) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, pnfx.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PatientNotAddedException.class)
	public ResponseEntity<Map<String, Object>> patientNotAddedHandler(PatientNotAddedException pnax) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, pnax.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(PatientNotUpdatedException.class)
	public ResponseEntity<Map<String, Object>> patientNotUpdatedHandler(PatientNotUpdatedException pnux) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, pnux.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_MODIFIED);
	}

	@ExceptionHandler(PatientNotDeletedException.class)
	public ResponseEntity<Map<String, Object>> patientNotDeletedHandler(PatientNotDeletedException pndx) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, pndx.getMessage());
		return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ReceptionistNotFoundException.class)
	public ResponseEntity<Map<String, Object>> receptionistNotFoundHandler(ReceptionistNotFoundException rnfx) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, rnfx.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ReceptionistNotAddedException.class)
	public ResponseEntity<Map<String, Object>> receptionistNotAddedHandler(ReceptionistNotAddedException rnax) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, rnax.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(ReceptionistNotUpdatedException.class)
	public ResponseEntity<Map<String, Object>> receptionistNotUpdatedHandler(ReceptionistNotUpdatedException rnux) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, rnux.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_MODIFIED);
	}

	@ExceptionHandler(ReceptionistNotDeletedException.class)
	public ResponseEntity<Map<String, Object>> receptionistNotDeletedHandler(ReceptionistNotDeletedException rndx) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, rndx.getMessage());
		return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(AppointmentNotFoundException.class)
	public ResponseEntity<Map<String, Object>> appointmentNotFoundHandler(AppointmentNotFoundException apnfx) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, apnfx.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AppointmentNotDeletedException.class)
	public ResponseEntity<Map<String, Object>> appointmentNotDeletedHanldler(AppointmentNotDeletedException andx) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, andx.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(AppointmentNotConfirmException.class)
	public ResponseEntity<Map<String, Object>> appointmentNotConfirmHanldler(AppointmentNotConfirmException ancx) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, ancx.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);
	}

}
