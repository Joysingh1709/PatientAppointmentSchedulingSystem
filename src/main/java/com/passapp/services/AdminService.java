package com.passapp.services;

import com.passapp.exceptions.AdminNotAddedException;
import com.passapp.exceptions.AdminNotDeletedException;
import com.passapp.exceptions.AdminNotFoundException;
import com.passapp.exceptions.AdminNotUpdatedException;
import com.passapp.models.Admin;

public interface AdminService {

	public Admin getAdmin(String username, String password) throws AdminNotFoundException;

	public Admin addAdmin(Admin admin) throws AdminNotAddedException;

	public Admin getAdminById(Long adminId) throws AdminNotFoundException;

	public boolean deleteAdminById(Long adminId) throws AdminNotDeletedException;

	public boolean deleteAdmin(Admin admin) throws AdminNotDeletedException;

	public boolean updateAdmin(Admin admin) throws AdminNotUpdatedException;

}
