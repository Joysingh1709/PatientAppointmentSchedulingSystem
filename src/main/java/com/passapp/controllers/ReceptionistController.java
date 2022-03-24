package com.passapp.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.passapp.models.Receptionist;
import com.passapp.services.AppointmentService;
import com.passapp.services.DoctorService;
import com.passapp.services.PatientService;

@RestController
@RequestMapping("/receptionist")
public class ReceptionistController {

	@Autowired
	PatientService patientService;

	@Autowired
	DoctorService doctorService;

	@Autowired
	AppointmentService appointmentService;

	@GetMapping()
	public ModelAndView getReceptionistDashboard(@ModelAttribute Receptionist receptionist) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("users", patientService.getAllPatients());
		model.put("doctors", doctorService.getAllDoctors());
		model.put("appointments", appointmentService.getAllAppointments());
		model.put("totalFee", doctorService.getTotalFeeRecieved());
		return new ModelAndView("receptionistDashboard", model);
	}

	@GetMapping("/deleteAppointment")
	public ModelAndView getReceptionistDeleteAppointment(@ModelAttribute Receptionist receptionist) {
		return new ModelAndView("deleteAppointment");
	}

	@GetMapping("/updateAppointment")
	public ModelAndView getReceptionistUpdateAppointment(@ModelAttribute Receptionist receptionist) {
		return new ModelAndView("updateAppointment");
	}

	@GetMapping("/updateSpecialization")
	public ModelAndView getReceptionistUpdateSpecialization(@ModelAttribute Receptionist receptionist) {
		return new ModelAndView("updateSpecialization");
	}

	@GetMapping("/patientPrescription")
	public ModelAndView getReceptionistPatientPrescription(@ModelAttribute Receptionist receptionist) {
		return new ModelAndView("patientPrescription");
	}

	@GetMapping("/appointmentPerDoctor")
	public ModelAndView getReceptionistPppointmentPerDoctor(@ModelAttribute Receptionist receptionist) {
		return new ModelAndView("appointmentPerDoctor");
	}

}
