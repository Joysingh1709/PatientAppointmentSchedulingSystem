package com.passapp.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
	
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
	}


