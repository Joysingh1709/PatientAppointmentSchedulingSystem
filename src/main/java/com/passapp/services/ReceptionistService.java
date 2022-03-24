package com.passapp.services;



import com.passapp.exceptions.ReceptionistNotFoundException;
import com.passapp.models.Receptionist;

public interface ReceptionistService {
  
	//CRUD Operations
	public Receptionist addReceptionist(Receptionist receptionist);


	public Receptionist getReceptionist(String email, String password) throws ReceptionistNotFoundException;
	


	
				
	public Receptionist getReceptionistById(Long receptionistId);
				
	public boolean deleteReceptionistById(Long receptionistId);
	public boolean deleteReceptionist(Receptionist receptionist);
				
	public boolean updateReceptionist(Receptionist receptionist);


}
