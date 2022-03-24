package com.passapp;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import com.passapp.controllers.ExceptionTestController;
import com.passapp.exceptions.AdminNotFoundException;
import com.passapp.exceptions.AppointmentNotFoundException;
import com.passapp.exceptions.DoctorNotFoundException;
import com.passapp.exceptions.PatientNotFoundException;
import com.passapp.exceptions.ReceptionistNotFoundException;

class ExceptionTestCase {

	ExceptionTestController methodForExceptionTest = new ExceptionTestController();
	
	@Test
	void AdminNotFoundHandler() {
		assertThrows(AdminNotFoundException.class, () -> {
			methodForExceptionTest.adminNotFoundHandler((long) 34324);
		});
	}
	
	
	@Test
	void DoctorNotFoundHandler() {
		assertThrows(DoctorNotFoundException.class, () -> {
			methodForExceptionTest.doctorNotFoundHandler((long) 1);
		});
	}
	
		
		@Test
		void PatientNotFoundHandler() {
			assertThrows(PatientNotFoundException.class, () -> {
				methodForExceptionTest.patientNotFoundHandler(null);
			});
	}
		
		
		@Test
		void ReceptionistNotFoundHandler() {
			assertThrows(ReceptionistNotFoundException.class, () -> {
				methodForExceptionTest.receptionistNotFoundHandler((long) 45466);
			});
		}
		
		
		@Test
		void AppointmentNotFoundHandler() {
			assertThrows(AppointmentNotFoundException.class, () -> {
				methodForExceptionTest.appointmentNotFoundHandler((long) 454634341);
			});
		}
		
		
}
