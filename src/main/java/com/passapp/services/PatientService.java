package com.passapp.services;

import java.util.List;

import com.passapp.models.User;

public interface PatientService {
    
	
	//CRUD Operations
	public User addPatient(User user);
			
	public List<User> getAllPatients();
    public User getPatientById(Long userId);
			
	public boolean deleteUserById(Long userId);
	public boolean deletePatient(User patient);
			
	public boolean updateUser(User user);
}
