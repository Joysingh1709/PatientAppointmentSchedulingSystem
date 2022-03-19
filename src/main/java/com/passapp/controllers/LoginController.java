package com.passapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.passapp.models.User;
@RequestMapping("/login")
public class LoginController {
	@GetMapping("/")
	public ModelAndView getPatientForm(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView("patientform");
		return modelAndView;
	}
}