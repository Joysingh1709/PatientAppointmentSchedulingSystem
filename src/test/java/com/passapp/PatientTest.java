package com.passapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.passapp.exceptions.PatientNotAddedException;
import com.passapp.exceptions.PatientNotDeletedException;
import com.passapp.exceptions.PatientNotFoundException;
import com.passapp.exceptions.PatientNotUpdatedException;
import com.passapp.models.User;
import com.passapp.services.PatientService;
@SpringBootTest(classes = PatientappointmentschedulingappApplication.class)
@Transactional
@Rollback(true)
 class PatientTest {

	@Autowired
	private PatientService patientService;
	
	public User addPatient() throws  PatientNotAddedException, PatientNotFoundException {
		User user = new User();
		user.setEmail("Rohit");
		user.setPassword("mickey");
		
		Long id =  patientService.addPatient(user).getUserId();
		return patientService.getPatientById(id);
	}
	

	
	@Test
	 void testAddPatient() throws PatientNotAddedException, PatientNotFoundException {
		User user = addPatient();
		assertEquals("Rohit", user.getEmail());
		assertEquals("mickey",user.getPassword());
		
	}
	
	@Test
	 void testUpdatePatient() throws PatientNotAddedException, PatientNotFoundException,PatientNotUpdatedException {
		User user = addPatient();
		user.setName("Kumar");
		patientService.updateUser(user);
		assertEquals("Kumar",patientService.getPatientById(user.getUserId()).getName());
	}
	

	@Test
	 void testDeletePatient() throws PatientNotAddedException,PatientNotFoundException,PatientNotDeletedException {
		User patient = addPatient();
		patientService.deletePatient(patient);
		assertThrows(PatientNotFoundException.class,()->{
		    patientService.getPatient(patient.getEmail(),patient.getPassword());
				});
	
	}
}
