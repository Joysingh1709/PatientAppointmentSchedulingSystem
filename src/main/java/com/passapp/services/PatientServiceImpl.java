package com.passapp.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passapp.exceptions.AppointmentNotFoundException;
import com.passapp.exceptions.EmailNotValidException;
import com.passapp.exceptions.PasswordNotValidException;
import com.passapp.exceptions.PatientNotAddedException;
import com.passapp.exceptions.PatientNotDeletedException;
import com.passapp.exceptions.PatientNotFoundException;
import com.passapp.exceptions.PatientNotUpdatedException;
import com.passapp.models.Appointments;
import com.passapp.models.User;
import com.passapp.repository.PatientRepository;
import com.passapp.utils.Validations;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	Validations validation;

	@Override

	public User addPatient(User user) throws PatientNotAddedException {
		if (Objects.isNull(user))
			throw new PatientNotAddedException("Patient not Added!");
		return patientRepository.save(user);
	}

	@Override
	public User getPatient(String email, String password)
			throws PatientNotFoundException, EmailNotValidException, PasswordNotValidException {

		if (!validation.isEmailValid(email)) {
			throw new EmailNotValidException("Please provide a valid email address..!");
		}

		if (!validation.isPasswordValid(password)) {
			throw new PasswordNotValidException("Please provide a valid Password..!");
		}

		User pa = patientRepository.getPatientByEmailAndPassword(email, password);
		if (pa != null)
			return pa;
		throw new PatientNotFoundException("Email or Password is incorrect!...");
	}

	@Override
	public List<User> getAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public User getPatientById(Long userId) throws PatientNotFoundException {
		Optional<User> user = patientRepository.findById(userId);
		if (user.isPresent()) {
			return user.get();
		}
		throw new PatientNotFoundException("Patient Id is incorrect!...");
	}

	@Override
	public boolean deleteUserById(Long userId) throws PatientNotFoundException, PatientNotDeletedException {
		User pat = patientRepository.getById(userId);
		if (pat != null) {
			patientRepository.deleteById(userId);
			if (patientRepository.existsById(userId)) {
				throw new PatientNotDeletedException("error deleting patient");
			}
			return true;
		}
		throw new PatientNotFoundException("Patient Id is incorrect!...");
	}

	@Override
	public boolean deletePatient(User patient) throws PatientNotDeletedException {
		patientRepository.delete(patient);
		if (patientRepository.existsById(patient.getUserId())) {
			throw new PatientNotDeletedException("Patient cannot be deleted!...");
		}
		return true;
	}

	@Override
	public boolean updateUser(User user) throws PatientNotUpdatedException {
		if (patientRepository.existsById(user.getUserId())) {
			User pat = patientRepository.save(user);
			if (pat != null) {
				return true;
			}
		}
		throw new PatientNotUpdatedException("Patient cannot be updated!...");

	}

	@Override
	public List<Appointments> getPatientAppointments(Long patientId) throws AppointmentNotFoundException {
		Optional<User> user = patientRepository.findById(patientId);
		if (user.isPresent()) {
			return patientRepository.getPatientAppointments(patientId);
		}
		throw new AppointmentNotFoundException("Patient Id has no Appointments!...");
	}

	@Override
	public List<Appointments> getRecentAppointments(Long patientId) throws AppointmentNotFoundException {
		Optional<User> user = patientRepository.findById(patientId);
		if (user.isPresent()) {
			return patientRepository.getRecentAppointments(patientId);
		}
		throw new AppointmentNotFoundException("Patient Id has no Appointments!...");
	}

}
