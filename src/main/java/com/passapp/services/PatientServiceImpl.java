package com.passapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.passapp.models.User;
import com.passapp.repository.PatientRepository;
@Service

public class PatientServiceImpl implements PatientService{
 
	@Autowired
 PatientRepository patientRepository;

	@Override
	public User addPatietnt(User user) {
		// TODO Auto-generated method stub
		return patientRepository.save(user);
	}

}
