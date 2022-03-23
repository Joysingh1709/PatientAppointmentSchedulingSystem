package com.passapp.services;

import java.util.List;

import com.passapp.exceptions.AppointmentNotFoundException;
import com.passapp.exceptions.DoctorNotFoundException;
import com.passapp.models.Appointments;


public interface AppointmentService {
	
	//CRUD Operations
	public Appointments addAppointments(Appointments appointments);
	public Appointments getAppointmentsById(Long appointmentId) throws AppointmentNotFoundException;
	public List<Appointments> getAllAppointments();
	public boolean deleteAppointmentsById(Long appointmentId) throws AppointmentNotFoundException;
	public boolean deleteAppointment(Appointments appointments) throws AppointmentNotFoundException;
	public boolean updateAppointments(Appointments appointments) throws AppointmentNotFoundException;
	
	public List<Appointments> getAllAppointmentsByDocId(Long doctorId);
	public List<Appointments> getAllAppointmentsByDocName(String name) throws AppointmentNotFoundException;

}
