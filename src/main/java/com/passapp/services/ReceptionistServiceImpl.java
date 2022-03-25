package com.passapp.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.passapp.exceptions.EmailNotValidException;
import com.passapp.exceptions.PasswordNotValidException;
import com.passapp.exceptions.ReceptionistNotAddedException;
import com.passapp.exceptions.ReceptionistNotDeletedException;
import com.passapp.exceptions.ReceptionistNotFoundException;
import com.passapp.exceptions.ReceptionistNotUpdatedException;
import com.passapp.models.Receptionist;
import com.passapp.repository.ReceptionistRepository;
import com.passapp.utils.Validations;

@Service
@Transactional
public class ReceptionistServiceImpl implements ReceptionistService {

	@Autowired
	ReceptionistRepository receptionistRepository;

	@Autowired
	Validations validation;

	@Override
	public Receptionist addReceptionist(Receptionist receptionist) throws ReceptionistNotAddedException {
		Receptionist recp = receptionistRepository.save(receptionist);
		if (receptionistRepository.existsById(recp.getReceptionistId())) {
			return recp;
		}
		throw new ReceptionistNotAddedException("recptionist not added..");
	}

	@Override
	public Receptionist getReceptionist(String email, String password)
			throws ReceptionistNotFoundException, EmailNotValidException, PasswordNotValidException {
		if (!validation.isEmailValid(email)) {
			throw new EmailNotValidException("Please provide a valid email address..!");
		}

		if (!validation.isPasswordValid(password)) {
			throw new PasswordNotValidException("Please provide a valid Password..!");
		}
		Receptionist recptn = receptionistRepository.getReceptionistByEmailAndPass(email, password);
		if (recptn != null) {
			return recptn;
		}
		throw new ReceptionistNotFoundException("Email or Password is incorrect...!");
	}

	@Override
	public Receptionist getReceptionistById(Long receptionistId) throws ReceptionistNotFoundException {
		Optional<Receptionist> receptionist = receptionistRepository.findById(receptionistId);
		if (receptionist.isPresent()) {
			return receptionist.get();
		}
		throw new ReceptionistNotFoundException("Receptionist not found");
	}

	@Override
	public boolean deleteReceptionistById(Long receptionistId) throws ReceptionistNotDeletedException {
		receptionistRepository.deleteById(receptionistId);
		if (receptionistRepository.existsById(receptionistId)) {
			throw new ReceptionistNotDeletedException("error deleting receptionist");
		}
		return true;
	}

	@Override
	public boolean deleteReceptionist(Receptionist receptionist) throws ReceptionistNotDeletedException {
		receptionistRepository.delete(receptionist);
		if (receptionistRepository.existsById(receptionist.getReceptionistId())) {
			throw new ReceptionistNotDeletedException("error deleting recptionist");
		}
		return true;
	}

	@Override
	public boolean updateReceptionist(Receptionist receptionist) throws ReceptionistNotUpdatedException {
		if (receptionistRepository.existsById(receptionist.getReceptionistId())) {
			Receptionist rec = receptionistRepository.save(receptionist);
			if (rec != null) {
				return true;
			}
		}
		throw new ReceptionistNotUpdatedException("error updating receptionist");
	}

}
