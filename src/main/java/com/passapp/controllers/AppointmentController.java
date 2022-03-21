package com.passapp.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.passapp.services.PatientService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private PatientService patientService;

//	@PostMapping("/saveAppointment")
//	public ModelAndView addpatient(@RequestBody Appointments appointment) {
////		Appointments apptmnt = appointmentService.addPatietnt(user);
//		ModelAndView modelAndView;
//		Map messageModel = new HashMap();
////		if (apptmnt != null) {
////			messageModel.put("appData", apptmnt);
////			modelAndView = new ModelAndView("success", messageModel);
////		} else {
////			messageModel.put("error", "Unable to create Appointment");
////			modelAndView = new ModelAndView("error", messageModel);
////		}
//		return modelAndView;
//	}

	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> getAllUserAppointments(@RequestParam Long patientId) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", true);
		res.put("message", "data found!");
		res.put("data", patientService.getPatientAppointments(Long patientId));
	}

}
