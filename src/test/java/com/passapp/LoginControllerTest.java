package com.passapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

class LoginControllerTest {

	@Autowired
	MockMvc mvc;

	@Test
	void testReceptionistLogin() {
		try {
			mvc.perform(post("/receptionist/login")).andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testDoctorLogin() {
		try {
			mvc.perform(post("/doctor/login")).andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testPatientLogin() {
		try {
			mvc.perform(post("/patient/login")).andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
