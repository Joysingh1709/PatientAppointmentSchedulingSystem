package com.passapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/admin", method = RequestMethod.GET)
public class AdminController {

	@GetMapping()
	public ModelAndView adminHome() {
		return new ModelAndView("admin");
	}

}
