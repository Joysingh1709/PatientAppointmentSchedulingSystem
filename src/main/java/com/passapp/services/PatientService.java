package com.passapp.services;

import java.util.List;

import com.passapp.exceptions.PatientNotFoundException;
import com.passapp.models.Appointments;
import com.passapp.models.User;

public interface PatientService {
    


	
	
	public User getPatient(String email, String password ) throws PatientNotFoundException;
	
	public List<Appointments> getPatientAppointments(Long patientId);

	
	//CRUD Operations
	public User addPatient(User user);
			
	public List<User> getAllPatients();
    public User getPatientById(Long userId);
			
	public boolean deleteUserById(Long userId);
	public boolean deletePatient(User patient);

	public boolean updateUser(User user);
	
	

}
