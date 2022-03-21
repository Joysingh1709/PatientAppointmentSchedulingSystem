package com.passapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.passapp.exceptions.ReceptionistNotFoundException;
import com.passapp.models.Receptionist;
import com.passapp.repository.ReceptionistRepository;

@Service
public class ReceptionistServiceImpl implements ReceptionistService {
	
	@Autowired
	ReceptionistRepository receptionistRepository;

	@Override
	public Receptionist addReceptionist(Receptionist receptionist) {
		
		return receptionistRepository.save(receptionist);
	}
	
	
	public Receptionist getReceptionist(String email, String password) throws ReceptionistNotFoundException
	{ 
		 Receptionist recptn = receptionistRepository.getReceptionistByEmailAndPass(email, password);
		  if(recptn!= null)
		  {
			  return recptn;
		  }
		 throw new ReceptionistNotFoundException("Email or Password is incorrect...!");
	}

}
