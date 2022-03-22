package com.passapp.services;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Appointments getAppointmentsById(Long appointmentId) {
		Optional<Appointments> appointments = appointmentRepository.findById(appointmentId);
		if(appointments.isPresent()) {
			return appointments.get();
		}
		return null;
	}

	@Override
	public boolean updateAppointments(Appointments appointments) {
		if(appointmentRepository.existsById(appointments.getAppointmentId())) {
			Appointments apt= appointmentRepository.save(appointments);
			if(apt!=null) {
			return true;
			}
		}
		return false;
	}

	@Override
	public List<Appointments> getAllAppointmentsByDocId(Long doctorId) {
		Optional<Appointments> appointments = appointmentRepository.findById(doctorId);
		if(appointments.isPresent()) {
			return appointmentRepository.getAllAppointmentsByDocId(doctorId) ;
		}
		return null;
	}

	@Override
	public List<Appointments> getAllAppointments() {
		
		return appointmentRepository.findAll();
	}

	@Override
	public boolean deleteAppointmentsById(Long appointmentId) {
		appointmentRepository.deleteById(appointmentId);
		if(appointmentRepository.existsById(appointmentId)) {
		return false;
		}
		return true;
	}

	@Override
	public boolean deleteAppointment(Appointments appointments) {
		appointmentRepository.delete(appointments);
		if(appointmentRepository.existsById(appointments.getAppointmentId())){
		     return false;
		}
		return true;
	}

	@Override
	public List<Appointments> getAllAppointmentsByDocName(String name) {
		List<Appointments> ap = appointmentRepository.getAppointmentByDocName(name);
		if(ap != null) {
			return ap;
		}
		return null;
	}

	
	

}
