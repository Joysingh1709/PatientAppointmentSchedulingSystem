package com.passapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

public class DoctorControllerTest {

	@Autowired
	MockMvc mvc;
	
	@Test
	void testGetDoctor() {
		try {
			mvc.perform(get("/getDoctor"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
