package com.passapp;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.passapp.exceptions.ReceptionistNotFoundException;
import com.passapp.models.Receptionist;
import com.passapp.services.ReceptionistService;
@SpringBootTest(classes = PatientappointmentschedulingappApplication.class)
@Transactional
@Rollback(true)
public class ReceptionistTest {
	

	@Autowired
	private ReceptionistService receptionistService;
	
	public Receptionist addReceptionist(){
		Receptionist receptionist = new Receptionist();
		receptionist.setName("Rohit");
		receptionist.setPassword("jayesh");
		Long id = receptionistService.addReceptionist(receptionist).getReceptionistId();
		return receptionistService.getReceptionistById(id);
	}
	

	@Test
	public void testAddReceptionist(){
		Receptionist receptionist = addReceptionist();
		assertEquals("Rohit", receptionist.getName());
		assertEquals("jayesh",receptionist.getPassword());
	}
	

	@Test
	public void testUpdateAdmin(){
		Receptionist receptionist = addReceptionist();
		receptionist.setName("Kumar");
		receptionistService.updateReceptionist(receptionist);
		assertEquals("Kumar",receptionistService.getReceptionistById(receptionist.getReceptionistId()).getName());
	}
	
	
	@Test
	public void testDeleteAdmin() {
		Receptionist receptionist = addReceptionist();
		receptionistService.deleteReceptionist(receptionist);
		assertThrows(ReceptionistNotFoundException.class, ()->{
			receptionistService.getReceptionist(receptionist.getEmail(),receptionist.getPassword());
			});
	
		}
	}