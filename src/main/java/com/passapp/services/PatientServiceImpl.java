package com.passapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passapp.exceptions.PatientNotFoundException;
import com.passapp.models.User;
import com.passapp.repository.PatientRepository;
@Service

public class PatientServiceImpl implements PatientService{
 
	@Autowired
 PatientRepository patientRepository;

	@Override
	public User addPatietnt(User user) {
		return patientRepository.save(user);
	}

	@Override
	public User getPatient(String email, String password) throws PatientNotFoundException {
		User pa = patientRepository.getPatientByEmailAndPassword(email, password);
		if(pa != null)
			return pa;
		throw new PatientNotFoundException("Email or Password is incorrect!...");
	}

}
