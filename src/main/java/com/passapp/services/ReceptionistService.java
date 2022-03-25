package com.passapp.services;

import com.passapp.exceptions.ReceptionistNotAddedException;
import com.passapp.exceptions.ReceptionistNotDeletedException;
import com.passapp.exceptions.ReceptionistNotFoundException;
import com.passapp.exceptions.ReceptionistNotUpdatedException;
import com.passapp.models.Receptionist;

public interface ReceptionistService {

	public Receptionist addReceptionist(Receptionist receptionist) throws ReceptionistNotAddedException;

	public Receptionist getReceptionist(String email, String password) throws ReceptionistNotFoundException;

	public Receptionist getReceptionistById(Long receptionistId) throws ReceptionistNotFoundException;

	public boolean deleteReceptionistById(Long receptionistId) throws ReceptionistNotDeletedException;

	public boolean deleteReceptionist(Receptionist receptionist) throws ReceptionistNotDeletedException;

	public boolean updateReceptionist(Receptionist receptionist) throws ReceptionistNotUpdatedException;

}
