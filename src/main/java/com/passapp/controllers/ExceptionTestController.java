package com.passapp.controllers;

import com.passapp.exceptions.AdminNotFoundException;
import com.passapp.exceptions.AppointmentNotFoundException;
import com.passapp.exceptions.DoctorNotFoundException;
import com.passapp.exceptions.PatientNotFoundException;
import com.passapp.exceptions.ReceptionistNotFoundException;

public class ExceptionTestController {

	public String AdminNotFoundHandler(Long adminId) throws AdminNotFoundException {
		throw new AdminNotFoundException();
	}
	
	public String DoctorNotFoundHandler(Long doctorId) throws DoctorNotFoundException {
		throw new DoctorNotFoundException();
	}
	
	public String PatientNotFoundHandler(Long userId) throws PatientNotFoundException {
		throw new PatientNotFoundException();
	}
	
	public String ReceptionistNotFoundHandler(Long receptionistId) throws ReceptionistNotFoundException {
		throw new ReceptionistNotFoundException();
	}
	
	public String AppointmentNotFoundHandler(Long appointmentId) throws AppointmentNotFoundException {
		throw new AppointmentNotFoundException();
	}
}

