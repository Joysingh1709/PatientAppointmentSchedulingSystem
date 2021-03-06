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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.passapp.exceptions.ReceptionistNotAddedException;
import com.passapp.models.Doctor;
import com.passapp.models.Receptionist;
import com.passapp.services.AppointmentService;
import com.passapp.services.DoctorService;
import com.passapp.services.PatientService;
import com.passapp.services.ReceptionistService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private PatientService patientService;

	@Autowired
	private AppointmentService appService;

	@Autowired
	private ReceptionistService receptionistService;

	@GetMapping()
	public ModelAndView adminHome() {
		Map<String, Object> model = new HashMap<>();
		model.put("doctors", doctorService.getAllDoctors());
		model.put("patients", patientService.getAllPatients());
		model.put("appointments", appService.getAllAppointments());
		return new ModelAndView("admin", model);
	}

	@GetMapping("/register")
	public ModelAndView adminRegisterationForms() {
		return new ModelAndView("adminRegistration");
	}

	@PostMapping("/saveDoctor")
	public ResponseEntity<Map<String, Object>> addDoctor(@RequestBody Doctor doctor) {
		Map<String, Object> res = new HashMap<>();
		res.put("status", true);
		res.put("message", "data inserted successfully!");
		res.put("data", doctorService.addDoctor(doctor));
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}

	@PostMapping("/saveReceptionist")
	public ResponseEntity<Map<String, Object>> addReceptionist(@RequestBody Receptionist receptionist)
			throws ReceptionistNotAddedException {
		Map<String, Object> res = new HashMap<>();
		res.put("status", true);
		res.put("message", "data inserted successfully!");
		res.put("data", receptionistService.addReceptionist(receptionist));
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}
}
