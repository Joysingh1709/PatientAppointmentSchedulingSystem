package com.passapp.services;

import java.util.List;

import com.passapp.models.Appointments;


public interface AppointmentService {
	
	//CRUD Operations
	public Appointments addAppointments(Appointments appointments);
	public Appointments getAppointmentsById(Long appointmentId);
	public List<Appointments> getAllAppointments();
	public boolean deleteAppointmentsById(Long appointmentId);
	public boolean deleteAppointment(Appointments appointments);
	public boolean updateAppointments(Appointments appointments);
	
	public List<Appointments> getAllAppointmentsByDocId(Long doctorId);
	public List<Appointments> getAllAppointmentsByDocName(String name);

}
