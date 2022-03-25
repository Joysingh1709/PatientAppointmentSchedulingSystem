package com.passapp.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passapp.exceptions.AdminNotAddedException;
import com.passapp.exceptions.AdminNotDeletedException;
import com.passapp.exceptions.AdminNotFoundException;
import com.passapp.exceptions.AdminNotUpdatedException;
import com.passapp.exceptions.EmailNotValidException;
import com.passapp.exceptions.PasswordNotValidException;
import com.passapp.models.Admin;
import com.passapp.repository.AdminRepository;
import com.passapp.utils.Validations;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	Validations validation;

	@Override
	public Admin getAdmin(String username, String password) throws AdminNotFoundException, PasswordNotValidException {

		if (!validation.isPasswordValid(password)) {
			throw new PasswordNotValidException("Please provide a valid Password..!");
		}

		Admin ad = adminRepository.getAdminByEmailAndPass(username, password);
		if (ad != null) {
			return ad;
		}
		throw new AdminNotFoundException("Username or password is incorrect..!");
	}

	@Override
	public Admin addAdmin(Admin admin) throws AdminNotAddedException {
		Admin ad = adminRepository.save(admin);
		if (adminRepository.existsById(ad.getAdminId())) {
			return ad;
		}
		throw new AdminNotAddedException("admin not added..!");
	}

	@Override
	public Admin getAdminById(Long adminId) throws AdminNotFoundException {
		Optional<Admin> admin = adminRepository.findById(adminId);
		if (admin.isPresent()) {
			return admin.get();
		}
		throw new AdminNotFoundException("admin not found");
	}

	@Override
	public boolean deleteAdminById(Long adminId) throws AdminNotDeletedException {
		adminRepository.deleteById(adminId);
		if (adminRepository.existsById(adminId)) {
			throw new AdminNotDeletedException("error deleting admin");
		}
		return true;
	}

	@Override
	public boolean deleteAdmin(Admin admin) throws AdminNotDeletedException {
		adminRepository.delete(admin);
		if (adminRepository.existsById(admin.getAdminId())) {
			throw new AdminNotDeletedException("error deleting admin");
		}
		return true;
	}

	@Override
	public boolean updateAdmin(Admin admin) throws AdminNotUpdatedException {
		if (adminRepository.existsById(admin.getAdminId())) {
			Admin adm = adminRepository.save(admin);
			if (adm != null) {
				return true;
			}
		}
		throw new AdminNotUpdatedException("error updating admin");
	}

}
