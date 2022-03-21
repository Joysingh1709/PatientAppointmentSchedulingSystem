package com.passapp.services;

import org.springframework.data.repository.query.Param;

import com.passapp.exceptions.ReceptionistNotFoundException;
import com.passapp.models.Receptionist;

public interface ReceptionistService {
	
	public Receptionist addReceptionist(Receptionist receptionist);
	public Receptionist getReceptionist(String email, String password) throws ReceptionistNotFoundException;
}
