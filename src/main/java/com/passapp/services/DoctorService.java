package com.passapp.services;

import java.util.List;

import com.passapp.exceptions.DoctorNotDeletedException;
import com.passapp.exceptions.DoctorNotFoundException;
import com.passapp.exceptions.DoctorNotUpdatedException;
import com.passapp.models.Doctor;

public interface DoctorService {

	public Doctor addDoctor(Doctor doctor);

	public List<Doctor> getAllDoctors();

	public Double getTotalFeeRecieved();

	public List<Doctor> getAllDoctorsByFee();

	public Doctor getDoctorById(Long doctorId) throws DoctorNotFoundException;

	public boolean deleteDoctorById(Long doctorId) throws DoctorNotDeletedException;

	public boolean deleteDoctor(Doctor doctor) throws DoctorNotDeletedException;

	public boolean updateDoctor(Doctor doctor) throws DoctorNotUpdatedException;

	public Doctor getDoctor(String email, String password) throws DoctorNotFoundException;

	public List<Doctor> getActiveDoctor() throws DoctorNotFoundException;

}
