package com.passapp.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.passapp.exceptions.AdminNotFoundException;

import com.passapp.models.Admin;
import com.passapp.repository.AdminRepository;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;

	@Override

	public Admin getAdmin(String userName, String password) throws AdminNotFoundException {
		Admin ad = adminRepository.getAdminByEmailAndPass(userName, password);
		if(ad != null)
		{ 
			return ad;
		}
		throw new AdminNotFoundException("Username or password is incorrect..!");
	}

	public Admin addAdmin(Admin admin) {
		
		return adminRepository.save(admin);
	}

	@Override
	public Admin getAdminById(Long adminId) {
		
		Optional<Admin> admin = adminRepository.findById(adminId);
		if(admin.isPresent()) {
			return admin.get();
		}
		return null;
	}

	@Override
	public boolean deleteAdminById(Long adminId) {
		adminRepository.deleteById(adminId);
		if(adminRepository.existsById(adminId)) {
		return false;
		}
		return true;
	}

	@Override
	public boolean deleteAdmin(Admin admin) {
		adminRepository.delete(admin);
		if(adminRepository.existsById(admin.getAdminId())){
		     return false;
		}
		return true;
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		if(adminRepository.existsById(admin.getAdminId())) {
			Admin adm= adminRepository.save(admin);
			if(adm!=null) {
			return true;
			}
		}
		return false;
	}

}
