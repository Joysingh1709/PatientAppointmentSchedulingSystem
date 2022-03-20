package com.passapp.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.passapp.models.User;
import com.passapp.services.PatientService;


@RestController
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	PatientService patientService;
	
	@PostMapping("/savepatient")
	public ModelAndView  addpatient(@RequestBody User user)
	{   
		User us= patientService.addPatietnt(user);
		ModelAndView modelAndView;
		Map messageModel =new HashMap();
		if (us != null) {
			messageModel.put("usData", us);
			modelAndView = new ModelAndView("success", messageModel);
		} else {
			messageModel.put("error", "Unable to add employee");
			modelAndView = new ModelAndView("error", messageModel);
		}
		return modelAndView;
		
	}
	


}
