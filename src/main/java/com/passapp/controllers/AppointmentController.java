package com.passapp.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.passapp.models.Appointments;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

//	@Autowired
//	private AppointmentService appointmentService;

	@PostMapping("/saveAppointment")
	public ModelAndView addpatient(@RequestBody Appointments appointment) {
//		Appointments apptmnt = appointmentService.addPatietnt(user);
		ModelAndView modelAndView;
		Map messageModel = new HashMap();
//		if (apptmnt != null) {
//			messageModel.put("appData", apptmnt);
//			modelAndView = new ModelAndView("success", messageModel);
//		} else {
//			messageModel.put("error", "Unable to create Appointment");
//			modelAndView = new ModelAndView("error", messageModel);
//		}
		return modelAndView;
	}

}
