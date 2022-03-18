package com.passapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passapp.models.Receptionist;
import com.passapp.repository.ReceptionistRepository;

@Service
public class ReceptionistServiceImpl implements ReceptionistService {
	
	@Autowired
	ReceptionistRepository receptionistRepository;

	@Override
	public Receptionist addReceptionist(Receptionist receptionist) {
		// TODO Auto-generated method stub
		return receptionistRepository.save(receptionist);
	}

}
