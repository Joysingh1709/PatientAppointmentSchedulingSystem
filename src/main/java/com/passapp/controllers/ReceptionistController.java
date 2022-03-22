package com.passapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.passapp.models.Receptionist;

@RestController
@RequestMapping("/receptionist")
public class ReceptionistController {

	@GetMapping(value = "/")
	public ModelAndView getReceptionistDashboard(@ModelAttribute Receptionist receptionist) {
		return new ModelAndView("receptionistDashboard");
	}

}
