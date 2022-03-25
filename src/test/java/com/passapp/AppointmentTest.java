package com.passapp;

import javax.transaction.Transactional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.passapp.exceptions.AppointmentNotFoundException;
import com.passapp.models.Appointments;
import com.passapp.services.AppointmentService;
@SpringBootTest(classes = PatientappointmentschedulingappApplication.class)
@Transactional
@Rollback(true)

 class AppointmentTest {
	
	@Autowired
	private AppointmentService appointmentService;
	
	public Appointments addAppointments() throws AppointmentNotFoundException{
		Appointments appointments = new Appointments();
		appointments.setPatientName("Rohit");
		appointments.setStatus("Pending");

		
		Long id =  appointmentService.addAppointments(appointments).getAppointmentId();
		return appointmentService.getAppointmentsById(id);
	}
	

	@Test
	 void testAddAppointments() throws AppointmentNotFoundException {
		Appointments appointments = addAppointments();
		assertEquals("Rohit", appointments.getPatientName());
		assertEquals("Pending",appointments.getStatus());
	}
	
	
	@Test
	 void testUpdateAppointments() throws AppointmentNotFoundException{
		Appointments appointments = addAppointments();
		appointments.setPatientName("Kumar");
		appointmentService.updateAppointments(appointments);
		assertEquals("Kumar",appointmentService.getAppointmentsById(appointments.getAppointmentId()).getPatientName());
	}
	
	
	@Test
	void testDeleteAdmin() throws AppointmentNotFoundException{
		Appointments appointments = addAppointments();
		appointmentService.deleteAppointment(appointments);
		assertThrows(AppointmentNotFoundException.class, ()->{
			appointmentService.getAppointmentsById(appointments.getAppointmentId());
			});
	}
}