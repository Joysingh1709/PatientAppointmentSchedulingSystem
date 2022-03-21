package com.passapp.services;



import com.passapp.exceptions.PatientNotFoundException;
import com.passapp.models.User;

public interface PatientService {
    
	public User addPatietnt(User user);
	public User getPatient(String email, String password ) throws PatientNotFoundException;
}
