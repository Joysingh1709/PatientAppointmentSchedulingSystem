package com.passapp.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passapp.repository.DoctorLoginRepository;

@Service
@Transactional
public class DoctorLoginServiceImpl implements DoctorLoginService {

	 @Autowired
	 DoctorLoginRepository doctorLoginRepository;
}
