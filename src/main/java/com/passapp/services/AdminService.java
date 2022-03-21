package com.passapp.services;



import com.passapp.exceptions.AdminNotFoundException;

import com.passapp.models.Admin;

public interface AdminService {
	

	public Admin getAdmin(String userName, String password) throws AdminNotFoundException;

	//CRUD Operations
	public Admin addAdmin(Admin admin);
	
	public Admin getAdminById(Long adminId);
	
	public boolean deleteAdminById(Long adminId);
	public boolean deleteAdmin(Admin admin);
	
	public boolean updateAdmin(Admin admin);


}
