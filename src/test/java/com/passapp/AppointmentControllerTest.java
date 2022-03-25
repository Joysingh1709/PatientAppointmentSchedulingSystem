package com.passapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

class AppointmentControllerTest {

	@Autowired
	MockMvc mvc;

	@Test
	void testGetAllAppointmentsByDoctorName() {
		try {
			mvc.perform(get("/doctorName/{doctorName}")).andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testGetAllAppointmentsByDoctorId() {
		try {
			mvc.perform(get("/doctorId/{doctorId}")).andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testGetAllAppointmentsById() {
		try {
			mvc.perform(get("/appointments/{appointmentId}")).andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
