package com.passapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest()
@AutoConfigureMockMvc
public class PatientControllerTest {
	
	@Autowired
	MockMvc mvc;
	
	@Test
	void testRecentAppointments() {
		try {
			mvc.perform(get("/getRecentAppointments/{patientId}"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testGetAppointmentByPatientId() {
		try {
			mvc.perform(get("/appointments/{patientId}"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*@Test
	void testBookAppointments() {
		try {
			mvc.perform(get("/patientBookAppointment"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}*/

}
