package com.passapp.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passapp.repository.LoginRepository;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{
 @Autowired
 LoginRepository loginRepository;
}
