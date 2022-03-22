package com.passapp.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.passapp.models.Doctor;
import com.passapp.models.Receptionist;
import com.passapp.services.DoctorService;
import com.passapp.services.ReceptionistService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private ReceptionistService receptionistService;

	@GetMapping(value = "/")
	public ModelAndView adminHome() {
		return new ModelAndView("admin");
	}

	@GetMapping("/register")
	public ModelAndView adminRegisterationForms() {
		return new ModelAndView("adminRegistration");
	}

	// http://localhost:8080/admin/saveDoctor
	@PostMapping("/saveDoctor")
	public ResponseEntity<Map<String, Object>> addDoctor(@RequestBody Doctor doctor) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", true);
		res.put("message", "data inserted successfully!");
		res.put("data", doctorService.addDoctor(doctor));
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.CREATED);
	}

	// http://localhost:8080/admin/saveReceptionist
	@PostMapping("/saveReceptionist")
	public ResponseEntity<Map<String, Object>> addReceptionist(@RequestBody Receptionist receptionist) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", true);
		res.put("message", "data inserted successfully!");
		res.put("data", receptionistService.addReceptionist(receptionist));
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.CREATED);
	}
}
