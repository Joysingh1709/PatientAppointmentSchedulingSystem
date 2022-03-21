package com.passapp.services;

import com.passapp.models.Admin;

public interface AdminService {
	
	//CRUD Operations
	public Admin addAdmin(Admin admin);
	
	public Admin getAdminById(Long adminId);
	
	public boolean deleteAdminById(Long adminId);
	public boolean deleteAdmin(Admin admin);
	
	public boolean updateAdmin(Admin admin);

}
