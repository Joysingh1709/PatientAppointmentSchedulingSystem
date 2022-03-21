package com.passapp.services;

import java.util.List;
import java.util.Optional;

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

	

	public User addPatient(User user) {

		return patientRepository.save(user);
	}

	@Override

	public User getPatient(String email, String password) throws PatientNotFoundException {
		User pa = patientRepository.getPatientByEmailAndPassword(email, password);
		if(pa != null)
			return pa;
		throw new PatientNotFoundException("Email or Password is incorrect!...");
	}
	public List<User> getAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public User getPatientById(Long userId) {
		Optional<User> user = patientRepository.findById(userId);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}

	@Override
	public boolean deleteUserById(Long userId) {
		patientRepository.deleteById(userId);
		if(patientRepository.existsById(userId)) {
		return false;
		}
		return true;
	}

	@Override
	public boolean deletePatient(User patient) {
		patientRepository.delete(patient);
		if(patientRepository.existsById(patient.getUserId())){
		     return false;
		}
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		if(patientRepository.existsById(user.getUserId())) {
			User pat= patientRepository.save(user);
			if(pat!=null) {
			return true;
			}
		}
		return false;

	}

	

}
