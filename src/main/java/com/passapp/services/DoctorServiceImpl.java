package com.passapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passapp.exceptions.DoctorNotFoundException;
import com.passapp.models.Doctor;
import com.passapp.repository.DoctorRepository;

@Service

public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorRepository doctorRepository;

	@Override
	public Doctor addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorRepository.save(doctor);
	}

	@Override
	public Doctor getDoctor(String email, String password) throws DoctorNotFoundException {
		Doctor doc = doctorRepository.getDoctorByEmailAndPass(email, password);
		if (doc != null) {
			return doc;
		}
		throw new DoctorNotFoundException("Email or password is incorrect..!");
	}

}
