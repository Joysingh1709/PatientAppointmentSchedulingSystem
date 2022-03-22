package com.passapp.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passapp.models.Appointments;
import com.passapp.services.AppointmentService;
import com.passapp.services.PatientService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	PatientService patientService;
	AppointmentService appointmentService;
	
	@PostMapping("/saveAppointments")
	public ResponseEntity<Map<String, Object>> addAppointments(@RequestBody Appointments appointments) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", true);
		res.put("message", "Appointment saved successfully!");
		res.put("data", appointmentService.addAppointments(appointments));
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.CREATED);

	}
	
	@DeleteMapping("/appointmentdel/{appointmentId}")
	public ResponseEntity<Void> deleteAppointmentById(Long appointmentId) {
		appointmentService.deleteAppointmentsById(appointmentId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/appointmentdelete")
	public ResponseEntity<Void> deleteAppointment(Appointments appointments) {
		appointmentService.deleteAppointment(appointments);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/appointmentupdate")
	public ResponseEntity<Appointments> updateAppointments(Appointments newAppointments) {
		appointmentService.updateAppointments(newAppointments);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/appointments/{appointmentId}")
	public ResponseEntity<Appointments> getAppointmentsById(@PathVariable Long appointmentId){
    	return new ResponseEntity<>(appointmentService.getAppointmentsById(appointmentId),HttpStatus.FOUND);
    }
	
	@GetMapping("/appointments/{doctorId}")
	public ResponseEntity<Appointments> getAllAppointmentsByDocId(@PathVariable Long doctorId){
		appointmentService.getAllAppointmentsByDocId(doctorId);
    	return new ResponseEntity<>(HttpStatus.FOUND);
    }
	
	@GetMapping("/appointments/{doctorName}")
	public ResponseEntity<Appointments> getAllAppointmentsByDocName(@PathVariable String name){
		appointmentService.getAllAppointmentsByDocName(name);
    	return new ResponseEntity<>(HttpStatus.FOUND);
    }
	

	
	
	

}
