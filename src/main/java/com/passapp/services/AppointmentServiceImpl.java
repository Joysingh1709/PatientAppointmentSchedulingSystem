package com.passapp.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.passapp.models.Appointments;
import com.passapp.repository.AppointmentRepository;

public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	AppointmentRepository appointmentRepository;

	@Override
	public Appointments addAppointments(Appointments appointments) {
		
		return appointmentRepository.save(appointments) ;
	}

}
