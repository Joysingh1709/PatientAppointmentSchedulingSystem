package com.passapp.controllers;

import com.passapp.exceptions.AdminNotFoundException;
import com.passapp.exceptions.AppointmentNotFoundException;
import com.passapp.exceptions.DoctorNotFoundException;
import com.passapp.exceptions.PatientNotFoundException;
import com.passapp.exceptions.ReceptionistNotFoundException;

public class ExceptionTestController {

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
}

