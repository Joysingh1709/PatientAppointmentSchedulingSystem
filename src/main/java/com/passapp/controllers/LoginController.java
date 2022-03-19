package com.passapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.passapp.models.User;
@RestController

public class LoginController {
	@GetMapping("/registration")
	public ModelAndView getPatientForm(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView("patientregistration");
		return modelAndView;
	}
	
	@GetMapping("/login")
	public ModelAndView getLoginPage(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView("LoginPage");
		return modelAndView;
	}
}