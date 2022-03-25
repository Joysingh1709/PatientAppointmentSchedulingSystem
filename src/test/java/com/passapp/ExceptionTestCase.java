package com.passapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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

class ExceptionTestCase {

	public String adminNotFoundHandler(Long adminId) throws AdminNotFoundException {
		throw new AdminNotFoundException();
	}

	public String adminNotAddedHandler(Long adminId) throws AdminNotAddedException {
		throw new AdminNotAddedException();
	}

	public String adminNotUpdatedHandler(Long adminId) throws AdminNotUpdatedException {
		throw new AdminNotUpdatedException();
	}

	public String adminNotDeletedHandler(Long adminId) throws AdminNotDeletedException {
		throw new AdminNotDeletedException();
	}

	public String doctorNotFoundHandler(Long doctorId) throws DoctorNotFoundException {
		throw new DoctorNotFoundException();
	}

	public String doctorNotAddedHandler(Long userId) throws DoctorNotAddedException {
		throw new DoctorNotAddedException();
	}

	public String doctorNotUpdatedHandler(Long userId) throws DoctorNotUpdatedException {
		throw new DoctorNotUpdatedException();
	}

	public String doctorNotDeletedHandler(Long userId) throws DoctorNotDeletedException {
		throw new DoctorNotDeletedException();
	}

	public String patientNotFoundHandler(Long userId) throws PatientNotFoundException {
		throw new PatientNotFoundException();
	}

	public String patientNotAddedHandler(Long userId) throws PatientNotAddedException {
		throw new PatientNotAddedException();
	}

	public String patientNotUpdatedHandler(Long userId) throws PatientNotUpdatedException {
		throw new PatientNotUpdatedException();
	}

	public String patientNotDeletedHandler(Long userId) throws PatientNotDeletedException {
		throw new PatientNotDeletedException();
	}

	public String receptionistNotFoundHandler(Long receptionistId) throws ReceptionistNotFoundException {
		throw new ReceptionistNotFoundException();
	}

	public String receptionistNotAddedHandler(Long userId) throws ReceptionistNotAddedException {
		throw new ReceptionistNotAddedException();
	}

	public String receptionistNotUpdatedHandler(Long userId) throws ReceptionistNotUpdatedException {
		throw new ReceptionistNotUpdatedException();
	}

	public String receptionistNotDeletedHandler(Long userId) throws ReceptionistNotDeletedException {
		throw new ReceptionistNotDeletedException();
	}

	public String appointmentNotFoundHandler(Long appointmentId) throws AppointmentNotFoundException {
		throw new AppointmentNotFoundException();
	}

	public String appointmentNotConfirmHandler(Long appointmentId) throws AppointmentNotConfirmException {
		throw new AppointmentNotConfirmException();
	}

	@Test
	void AdminNotFoundHandler() {
		assertThrows(AdminNotFoundException.class, () -> {
			adminNotFoundHandler((long) 34324);
		});
	}

	@Test
	void AdminNotAddedHandler() {
		assertThrows(AdminNotAddedException.class, () -> {
			adminNotAddedHandler((long) 3433);
		});
	}

	@Test
	void AdminNotUpdatedHandler() {
		assertThrows(AdminNotUpdatedException.class, () -> {
			adminNotUpdatedHandler((long) 3424);
		});
	}

	@Test
	void AdminNotDeletedHandler() {
		assertThrows(AdminNotDeletedException.class, () -> {
			adminNotDeletedHandler((long) 343784);
		});
	}

	@Test
	void DoctorNotFoundHandler() {
		assertThrows(DoctorNotFoundException.class, () -> {
			doctorNotFoundHandler((long) 1);
		});
	}

	@Test
	void DoctorNotAddedHandler() {
		assertThrows(DoctorNotAddedException.class, () -> {
			doctorNotAddedHandler((long) 87899);
		});
	}

	@Test
	void DoctorNotUpdatedHandler() {
		assertThrows(DoctorNotUpdatedException.class, () -> {
			doctorNotUpdatedHandler((long) 564);
		});
	}

	@Test
	void DoctorNotDeletedHandler() {
		assertThrows(DoctorNotDeletedException.class, () -> {
			doctorNotDeletedHandler((long) 14534);
		});
	}

	@Test
	void PatientNotFoundHandler() {
		assertThrows(PatientNotFoundException.class, () -> {
			patientNotFoundHandler(null);
		});
	}

	@Test
	void PatientNotAddedHandler() {
		assertThrows(PatientNotAddedException.class, () -> {
			patientNotAddedHandler((long) 67);
		});
	}

	@Test
	void PatientNotUpdatedHandler() {
		assertThrows(PatientNotUpdatedException.class, () -> {
			patientNotUpdatedHandler((long) 3424);
		});
	}

	@Test
	void PatientNotDeletedHandler() {
		assertThrows(PatientNotDeletedException.class, () -> {
			patientNotDeletedHandler((long) 34431);
		});
	}

	@Test
	void ReceptionistNotFoundHandler() {
		assertThrows(ReceptionistNotFoundException.class, () -> {
			receptionistNotFoundHandler((long) 6556);
		});
	}

	@Test
	void ReceptionistNotAddedHandler() {
		assertThrows(ReceptionistNotAddedException.class, () -> {
			receptionistNotAddedHandler((long) 897);
		});
	}

	@Test
	void ReceptionistNotUpdatedHandler() {
		assertThrows(ReceptionistNotUpdatedException.class, () -> {
			receptionistNotUpdatedHandler((long) 232143);
		});
	}

	@Test
	void ReceptionistNotDeletedHandler() {
		assertThrows(ReceptionistNotDeletedException.class, () -> {
			receptionistNotDeletedHandler((long) 95384);
		});
	}

	@Test
	void AppointmentNotFoundHandler() {
		assertThrows(AppointmentNotFoundException.class, () -> {
			appointmentNotFoundHandler((long) 454634341);
		});
	}

	@Test
	void AppointmentNotConfirmHandler() {
		assertThrows(AppointmentNotConfirmException.class, () -> {
			appointmentNotConfirmHandler((long) 54341);
		});
	}

}
