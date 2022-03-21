package com.passapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

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

	@Override
	public Receptionist getReceptionistById(Long receptionistId) {
		Optional<Receptionist> receptionist = receptionistRepository.findById(receptionistId);
		if(receptionist.isPresent()) {
			return receptionist.get();
		}
		return null;
	}

	@Override
	public boolean deleteReceptionistById(Long receptionistId) {
		receptionistRepository.deleteById(receptionistId);
		if(receptionistRepository.existsById(receptionistId)) {
		return false;
		}
		return true;
	}

	@Override
	public boolean deleteReceptionist(Receptionist receptionist) {
		receptionistRepository.delete(receptionist);
		if(receptionistRepository.existsById(receptionist.getReceptionistId())){
		     return false;
		}
		return true;
	}

	@Override
	public boolean updateReceptionist(Receptionist receptionist) {
		if(receptionistRepository.existsById(receptionist.getReceptionistId())) {
			Receptionist rec= receptionistRepository.save(receptionist);
			if(rec!=null) {
			return true;
			}
		}
		return false;
	}

}
