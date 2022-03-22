package com.passapp.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.passapp.exceptions.DoctorNotFoundException;
import com.passapp.models.Doctor;
import com.passapp.services.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@GetMapping(value = "/")
	public ModelAndView getDoctorDashboard(@ModelAttribute Doctor doctor) {
		ModelAndView modelAndView = new ModelAndView("doctorDashboard");
		return modelAndView;
	}

	@GetMapping("/getDoctor")
	public ResponseEntity<Map<String, Object>> getDoctor(@RequestBody Map<String, Object> body)
			throws DoctorNotFoundException {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", true);
		res.put("message", "data found!");
		res.put("data", doctorService.getDoctor(body.get("email").toString(), body.get("password").toString()));
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
	}

}
