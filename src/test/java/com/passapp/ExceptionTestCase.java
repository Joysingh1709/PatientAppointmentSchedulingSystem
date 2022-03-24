package com.passapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.passapp.exceptions.AdminNotFoundException;
import com.passapp.exceptions.AppointmentNotFoundException;
import com.passapp.exceptions.DoctorNotFoundException;
import com.passapp.exceptions.PatientNotFoundException;
import com.passapp.exceptions.ReceptionistNotFoundException;

class ExceptionTestCase {

	public String adminNotFoundHandler(Long adminId) throws AdminNotFoundException {
		throw new AdminNotFoundException();
	}

	public String doctorNotFoundHandler(Long doctorId) throws DoctorNotFoundException {
		throw new DoctorNotFoundException();
	}

	public String patientNotFoundHandler(Long userId) throws PatientNotFoundException {
		throw new PatientNotFoundException();
	}

	public String receptionistNotFoundHandler(Long receptionistId) throws ReceptionistNotFoundException {
		throw new ReceptionistNotFoundException();
	}

	public String appointmentNotFoundHandler(Long appointmentId) throws AppointmentNotFoundException {
		throw new AppointmentNotFoundException();
	}

	@Test
	void AdminNotFoundHandler() {
		assertThrows(AdminNotFoundException.class, () -> {
			adminNotFoundHandler((long) 34324);
		});
	}

	@Test
	void DoctorNotFoundHandler() {
		assertThrows(DoctorNotFoundException.class, () -> {
			doctorNotFoundHandler((long) 1);
		});
	}

	@Test
	void PatientNotFoundHandler() {
		assertThrows(PatientNotFoundException.class, () -> {
			patientNotFoundHandler(null);
		});
	}

	@Test
	void ReceptionistNotFoundHandler() {
		assertThrows(ReceptionistNotFoundException.class, () -> {
			receptionistNotFoundHandler((long) 45466);
		});
	}

	@Test
	void AppointmentNotFoundHandler() {
		assertThrows(AppointmentNotFoundException.class, () -> {
			appointmentNotFoundHandler((long) 454634341);
		});
	}

}
