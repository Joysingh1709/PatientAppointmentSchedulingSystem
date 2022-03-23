package com.passapp.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
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

import com.passapp.exceptions.AppointmentNotFoundException;
import com.passapp.exceptions.PatientNotAddedException;
import com.passapp.exceptions.PatientNotFoundException;
import com.passapp.models.Appointments;
import com.passapp.models.Doctor;
import com.passapp.models.User;
import com.passapp.services.AppointmentService;
import com.passapp.services.DoctorService;
import com.passapp.services.PatientService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	PatientService patientService;

	@Autowired
	DoctorService doctorService;

	@Autowired
	AppointmentService appointmentService;

	@PostMapping("/saveAppointments")
	public ResponseEntity<Map<String, Object>> addAppointments(@RequestBody Map<String, Object> body)
			throws PatientNotAddedException, ParseException, PatientNotFoundException {

		DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Appointments newAppointment = new Appointments();
		newAppointment.setCreatedDate((Date) simpleDateFormat.parse(body.get("createdDate").toString()));
		newAppointment.setUpdatedDate((Date) simpleDateFormat.parse(body.get("updatedDate").toString()));
		newAppointment.setProblem(body.get("problem").toString());
		newAppointment.setStatus(body.get("status").toString());
		newAppointment.setAppointmentTime(LocalDate.parse(body.get("appointmentTime").toString()));
		newAppointment.setPatientName(body.get("patientName").toString());
		newAppointment.setPatientGender(body.get("patientGender").toString());
		newAppointment.setPatientDOB((Date) simpleDateFormat.parse(body.get("patientDOB").toString()));

		Doctor doc = doctorService.getDoctorById(Long.valueOf((Integer) body.get("doctorId")));
		User user = patientService.getPatientById(Long.valueOf((Integer) body.get("userId")));

		newAppointment.setUser(user);
		newAppointment.setDoctor(doc);

		patientService.addPatient(user);
		doctorService.addDoctor(doc);

		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", true);
		res.put("message", "Appointment booked successfully!");
		res.put("data", appointmentService.addAppointments(newAppointment));
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
	}

	@DeleteMapping("/appointmentdel/{appointmentId}")
	public ResponseEntity<Void> deleteAppointmentById(Long appointmentId) throws AppointmentNotFoundException {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", true);
		res.put("message", "Appointment deleted successfully!");
		res.put("data", appointmentService.deleteAppointmentsById(appointmentId));
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/appointmentdelete")
	public ResponseEntity<Void> deleteAppointment(Appointments appointments) throws AppointmentNotFoundException {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", true);
		res.put("message", "Appointment deleted successfully!");
		res.put("data", appointmentService.deleteAppointment(appointments));
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/appointmentupdate")
	public ResponseEntity<Appointments> updateAppointments(Appointments newAppointments)
			throws AppointmentNotFoundException {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", true);
		res.put("message", "Appointment updated successfully!");
		res.put("data", appointmentService.updateAppointments(newAppointments));
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/appointments/{appointmentId}")
	public ResponseEntity<Appointments> getAppointmentsById(@PathVariable Long appointmentId)
			throws AppointmentNotFoundException {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", true);
		res.put("message", "Appointments with Id!");
		res.put("data", appointmentService.getAppointmentsById(appointmentId));
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/doctorId/{doctorId}")
	public ResponseEntity<Map<String, Object>> getAllAppointmentsByDocId(@PathVariable Long doctorId) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", true);
		res.put("message", "Appointments with Doctor Id!");
		res.put("data", appointmentService.getAllAppointmentsByDocId(doctorId));
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
	}

	@GetMapping("/doctorName/{doctorName}")
	public ResponseEntity<Map<String, Object>> getAllAppointmentsByDocName(@PathVariable String name)
			throws AppointmentNotFoundException {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", true);
		res.put("message", "Appointments with Doctor Name!");
		res.put("data", appointmentService.getAllAppointmentsByDocName(name));
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
	}

}
