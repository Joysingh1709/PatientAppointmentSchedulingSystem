package com.passapp.services;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<Doctor> getAllDoctors() {
		
		return doctorRepository.findAll();
	}

	@Override
	public Doctor getDoctorById(Long doctorId) {
		
		Optional<Doctor> doctor = doctorRepository.findById(doctorId);
		if(doctor.isPresent()) {
			return doctor.get();
		}
		return null;
	}

	@Override
	public boolean deleteDoctorById(Long doctorId) {
		doctorRepository.deleteById(doctorId);
		if(doctorRepository.existsById(doctorId)) {
		return false;
		}
		return true;

	}

	@Override
	public boolean deleteDoctor(Doctor doctor) {
		doctorRepository.delete(doctor);
		if(doctorRepository.existsById(doctor.getDoctorId())){
		     return false;
		}
		return true;
	}

	@Override
	public boolean updateDoctor(Doctor doctor) {
		if(doctorRepository.existsById(doctor.getDoctorId())) {
			Doctor doc= doctorRepository.save(doctor);
			if(doc!=null) {
			return true;
			}
		}
		return false;
	}

}
