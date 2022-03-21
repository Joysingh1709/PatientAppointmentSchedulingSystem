package com.passapp.services;

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
	public Admin getAdmin(String username, String password) throws AdminNotFoundException {
		Admin ad = adminRepository.getAdminByEmailAndPass(username, password);
		if(ad != null)
		{ 
			return ad;
		}
		throw new AdminNotFoundException("Username or password is incorrect..!");
}
}