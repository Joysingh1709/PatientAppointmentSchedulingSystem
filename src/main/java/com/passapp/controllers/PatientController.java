package com.passapp.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.passapp.exceptions.AppointmentNotFoundException;
import com.passapp.exceptions.PatientNotAddedException;
import com.passapp.models.Appointments;
import com.passapp.models.User;
import com.passapp.services.AppointmentService;
import com.passapp.services.DoctorService;
import com.passapp.services.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	PatientService patientService;

	@Autowired
	AppointmentService appointmentService;

	@Autowired
	DoctorService doctorService;

	@GetMapping()
	public ModelAndView getPatientDashboard(@ModelAttribute User patient) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("topDoctors", doctorService.getAllDoctorsByFee());
		return new ModelAndView("patientDashboard", model);
	}

	@GetMapping("/patientReview")
	public ModelAndView getPatientReview(@ModelAttribute User patient) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("doctors", doctorService.getAllDoctors());
		return new ModelAndView("patientReview", model);
	}

	@GetMapping("/patientTotalAppointment")
	public ModelAndView getPatientTotalAppointment(@ModelAttribute User patient) {
		return new ModelAndView("patientTotalAppointment");
	}

	@GetMapping("/patientBookAppointment")
	public ModelAndView getPatientBookAppointment(@ModelAttribute User patient) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("doctors", doctorService.getAllDoctors());
		return new ModelAndView("patientBookAppointment", model);
	}

	@PostMapping("/savePatient")
	public ResponseEntity<Map<String, Object>> addpatient(@RequestBody User user) throws PatientNotAddedException {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", true);
		res.put("message", "data inserted successfully!");
		res.put("data", patientService.addPatient(user));
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.CREATED);

	}

	@GetMapping("/getRecentAppointments/{patientId}")
	public ResponseEntity<Map<String, Object>> getPatientRecentAppointments(@PathVariable Long patientId)
			throws AppointmentNotFoundException {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", true);
		res.put("message", "data found!");
		res.put("data", patientService.getRecentAppointments(patientId));
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
	}

	@GetMapping("/appointments/{patientId}")
	public ResponseEntity<Map<String, Object>> getPatientAppointments(@PathVariable Long patientId)
			throws AppointmentNotFoundException {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", true);
		res.put("message", "data found!");
		res.put("data", patientService.getPatientAppointments(patientId));
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
	}

	@PostMapping("/bookAppointments")
	public ResponseEntity<Map<String, Object>> addAppointments(@RequestBody Appointments appointments) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", true);
		res.put("message", "Appointment booked successfully!");
		res.put("data", appointmentService.addAppointments(appointments));
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.CREATED);
	}

	@GetMapping("/recentappointments/{patientId}")
	public ResponseEntity<Appointments> getRecentAppointments(@PathVariable Long patientId)
			throws AppointmentNotFoundException {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", true);
		res.put("message", "Recent Appointments!");
		res.put("data", patientService.getRecentAppointments(patientId));
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
