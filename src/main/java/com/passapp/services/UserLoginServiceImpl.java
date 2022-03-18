package com.passapp.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passapp.repository.UserLoginRepository;

@Service
@Transactional
public class UserLoginServiceImpl implements UserLoginService {

	 @Autowired
	 UserLoginRepository userLoginRepository;
}
