package com.passapp.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passapp.repository.ReceptionistLoginRepository;

@Service
@Transactional
public class ReceptionistLoginServiceImpl implements ReceptionistLoginService{
 @Autowired
 ReceptionistLoginRepository loginRepository;
}
