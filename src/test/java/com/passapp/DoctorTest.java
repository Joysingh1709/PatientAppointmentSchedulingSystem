package com.passapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.DuplicateFormatFlagsException;

import javax.transaction.Transactional;

import org.hibernate.DuplicateMappingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.passapp.exceptions.DoctorNotFoundException;
import com.passapp.models.Doctor;
import com.passapp.services.DoctorService;

@SpringBootTest(classes = PatientappointmentschedulingappApplication.class)
@Transactional
@Rollback(true)
class DoctorTest {

	@Autowired
	private DoctorService doctorService;

	public Doctor addDoctor() throws DuplicateFormatFlagsException, DoctorNotFoundException {
		Doctor doctor = new Doctor();
		doctor.setEmail("Rohit");
		doctor.setPassword("mickey");
		doctor.setStatus(true);
		Long id = doctorService.addDoctor(doctor).getDoctorId();
		return doctorService.getDoctorById(id);
	}

	@Test
	 void testAddDoctor() throws DuplicateMappingException, DoctorNotFoundException,
			DuplicateFormatFlagsException, DoctorNotFoundException {
		Doctor doctor = addDoctor();
		assertEquals("Rohit", doctor.getEmail());
		assertEquals("mickey", doctor.getPassword());
		assertEquals(true, doctor.getStatus());
	}

	@Test
	 void testUpdateDoctor() throws DuplicateMappingException, DoctorNotFoundException {
		Doctor doctor = addDoctor();
		doctor.setName("Kumar");
		doctorService.updateDoctor(doctor);
		assertEquals("Kumar", doctorService.getDoctorById(doctor.getDoctorId()).getName());
	}

	@Test
	 void testDeleteDoctor() throws DuplicateMappingException, DoctorNotFoundException {
		Doctor doctor = addDoctor();
		doctorService.deleteDoctor(doctor);
		assertThrows(DoctorNotFoundException.class, () -> {
			doctorService.getDoctor(doctor.getEmail(), doctor.getPassword());
		});
	}

}
