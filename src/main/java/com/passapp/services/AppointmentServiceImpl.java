package com.passapp.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passapp.exceptions.AppointmentNotFoundException;
import com.passapp.exceptions.DoctorNotFoundException;
import com.passapp.models.Appointments;
import com.passapp.repository.AppointmentRepository;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepository;

	@Override
	public Appointments addAppointments(Appointments appointments) {

		return appointmentRepository.save(appointments);
	}

	@Override
	public Appointments getAppointmentsById(Long appointmentId) throws AppointmentNotFoundException {
		Optional<Appointments> appointments = appointmentRepository.findById(appointmentId);
		if (appointments.isPresent()) {
			return appointments.get();
		}
		throw new AppointmentNotFoundException("Appointment Id is invalid!!");
	}

	@Override
	public boolean updateAppointments(Appointments appointments) throws AppointmentNotFoundException {
		if (appointmentRepository.existsById(appointments.getAppointmentId())) {
			Appointments apt = appointmentRepository.save(appointments);
			if (apt != null) {
				return true;
			}
		}
		throw new AppointmentNotFoundException("Appointment Not Found!!");
	}

	@Override
	public List<Appointments> getAllAppointmentsByDocId(Long doctorId) throws DoctorNotFoundException {
		Optional<Appointments> appointments = appointmentRepository.findById(doctorId);
		if (appointments.isPresent()) {
			return appointmentRepository.getAllAppointmentsByDocId(doctorId);
		}
		throw new DoctorNotFoundException("Invalid Doctor Id!!");
	}

	@Override
	public List<Appointments> getAllAppointments() {

		return appointmentRepository.findAll();
	}

	@Override
	public boolean deleteAppointmentsById(Long appointmentId) throws AppointmentNotFoundException {
		appointmentRepository.deleteById(appointmentId);
		if (appointmentRepository.existsById(appointmentId)) {
			return false;
		}
		throw new AppointmentNotFoundException("Appointment Id is invalid!!");
	}

	@Override
	public boolean deleteAppointment(Appointments appointments) throws AppointmentNotFoundException {
		appointmentRepository.delete(appointments);
		if (appointmentRepository.existsById(appointments.getAppointmentId())) {
			return false;
		}
		throw new AppointmentNotFoundException("Appointment Not Found!!");
	}

	@Override
	public List<Appointments> getAllAppointmentsByDocName(String name) throws DoctorNotFoundException {
		List<Appointments> ap = appointmentRepository.getAppointmentByDocName(name);
		if (ap != null) {
			return ap;
		}
		throw new DoctorNotFoundException("Invalid Doctor Name!!");
	}

}
