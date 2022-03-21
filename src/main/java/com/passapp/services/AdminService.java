package com.passapp.services;


import com.passapp.exceptions.AdminNotFoundException;
import com.passapp.models.Admin;

public interface AdminService {
	
	public Admin getAdmin(String username, String password) throws AdminNotFoundException;

}
