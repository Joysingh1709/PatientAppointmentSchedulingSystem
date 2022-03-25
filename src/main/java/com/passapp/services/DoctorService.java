package com.passapp.services;

import java.util.List;

import com.passapp.exceptions.DoctorNotFoundException;
import com.passapp.models.Doctor;

public interface DoctorService {

	// CRUD Operations
	public Doctor addDoctor(Doctor doctor);

	public List<Doctor> getAllDoctors();

	public Double getTotalFeeRecieved();

	public List<Doctor> getAllDoctorsByFee();

	public Doctor getDoctorById(Long doctorId);

	public boolean deleteDoctorById(Long doctorId);

	public boolean deleteDoctor(Doctor doctor);

	public boolean updateDoctor(Doctor doctor);

	public Doctor getDoctor(String email, String password) throws DoctorNotFoundException;

	public List<Doctor> getActiveDoctor() throws DoctorNotFoundException;

}
