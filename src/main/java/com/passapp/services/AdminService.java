package com.passapp.services;

import com.passapp.exceptions.AdminNotAddedException;
import com.passapp.exceptions.AdminNotFoundException;

import com.passapp.models.Admin;

public interface AdminService {

	public Admin getAdmin(String username, String password) throws AdminNotFoundException;

	public Admin addAdmin(Admin admin) throws AdminNotAddedException;

	public Admin getAdminById(Long adminId);

	public boolean deleteAdminById(Long adminId);

	public boolean deleteAdmin(Admin admin);

	public boolean updateAdmin(Admin admin);

}
