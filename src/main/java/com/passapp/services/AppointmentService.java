package com.passapp.services;

import java.util.List;

import com.passapp.exceptions.AppointmentNotDeletedException;
import com.passapp.exceptions.AppointmentNotFoundException;
import com.passapp.models.Appointments;

public interface AppointmentService {

	public Appointments addAppointments(Appointments appointments);

	public Appointments getAppointmentsById(Long appointmentId) throws AppointmentNotFoundException;

	public List<Appointments> getAllAppointments();

	public boolean deleteAppointmentsById(Long appointmentId) throws AppointmentNotDeletedException;

	public boolean deleteAppointment(Appointments appointments) throws AppointmentNotDeletedException;

	public boolean updateAppointments(Appointments appointments) throws AppointmentNotFoundException;

	public List<Appointments> getAllAppointmentsByDocId(Long doctorId);

	public List<Appointments> getAllAppointmentsByDocName(String name) throws AppointmentNotFoundException;

}
