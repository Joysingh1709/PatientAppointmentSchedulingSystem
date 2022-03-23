package com.passapp.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.passapp.exceptions.DoctorNotFoundException;
import com.passapp.exceptions.PatientNotFoundException;
import com.passapp.exceptions.ReceptionistNotFoundException;
import com.passapp.models.User;
import com.passapp.services.DoctorService;
import com.passapp.services.PatientService;
import com.passapp.services.ReceptionistService;

@RestController

public class LoginController {

	@Autowired
	PatientService patientService;

	@Autowired
	DoctorService doctorService;

	@Autowired
	ReceptionistService receptionistService;

	@GetMapping()
	public ModelAndView getHomePage() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("doctors", doctorService.getAllDoctors());
		ModelAndView modelAndView = new ModelAndView("index", model);
		return modelAndView;
	}

	@GetMapping("/registration")
	public ModelAndView getPatientForm(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView("patientregistration");
		return modelAndView;
	}

	@GetMapping("/adminLogin")
	public ModelAndView getAdminLoginPage(@ModelAttribute User user) {
		return new ModelAndView("adminLoginPage");
	}

	@GetMapping("/login")
	public ModelAndView getLoginPage(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView("LoginPage");
		return modelAndView;
	}

	@PostMapping("/patient/login")
	public ResponseEntity<Map<String, Object>> patientLogin(@RequestBody Map<String, Object> body)
			throws PatientNotFoundException {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", true);
		res.put("message", "data inserted successfully!");
		res.put("data", patientService.getPatient(body.get("email").toString(), body.get("password").toString()));

		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
	}

	@PostMapping("/doctor/login")
	public ResponseEntity<Map<String, Object>> doctorLogin(@RequestBody Map<String, Object> body)
			throws DoctorNotFoundException {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", true);
		res.put("message", "data inserted successfully!");
		res.put("data", doctorService.getDoctor(body.get("email").toString(), body.get("password").toString()));

		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
	}

	@PostMapping("/receptionist/login")
	public ResponseEntity<Map<String, Object>> receptionistLogin(@RequestBody Map<String, Object> body)
			throws ReceptionistNotFoundException {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", true);
		res.put("message", "data inserted successfully!");
		res.put("data",
				receptionistService.getReceptionist(body.get("email").toString(), body.get("password").toString()));

		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
	}

}