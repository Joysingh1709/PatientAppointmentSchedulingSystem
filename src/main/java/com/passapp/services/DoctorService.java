package com.passapp.services;

import com.passapp.exceptions.DoctorNotFoundException;
import com.passapp.models.Doctor;

public interface DoctorService {

	public Doctor addDoctor(Doctor doctor);

	public Doctor getDoctor(String email, String password) throws DoctorNotFoundException;

}
