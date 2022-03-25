package com.passapp.services;

import java.util.List;

import com.passapp.exceptions.AppointmentNotFoundException;
import com.passapp.exceptions.PatientNotAddedException;
import com.passapp.exceptions.PatientNotDeletedException;
import com.passapp.exceptions.PatientNotFoundException;
import com.passapp.exceptions.PatientNotUpdatedException;
import com.passapp.models.Appointments;
import com.passapp.models.User;

public interface PatientService {

	public User getPatient(String email, String password) throws PatientNotFoundException;

	public List<Appointments> getPatientAppointments(Long patientId) throws AppointmentNotFoundException;

	public List<Appointments> getRecentAppointments(Long patientId) throws AppointmentNotFoundException;

	public User addPatient(User user) throws PatientNotAddedException;

	public List<User> getAllPatients();

	public User getPatientById(Long userId) throws PatientNotFoundException;

	public boolean deleteUserById(Long userId) throws PatientNotFoundException, PatientNotDeletedException;

	public boolean deletePatient(User patient) throws PatientNotDeletedException;

	public boolean updateUser(User user) throws PatientNotUpdatedException;

}
