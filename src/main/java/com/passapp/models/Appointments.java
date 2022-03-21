package com.passapp.models;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="appointments")
public class Appointments {
	
	@Id
	@GeneratedValue
	private Long appointmentId;
	private Date createdDate;
	private Date updatedDate;
	private String problem;
	private String status;
	private LocalDate appointmentTime;
	private String patientName;
	private String patientGender;
	private Date patientDOB;
	
	@ManyToOne
    @JoinColumn(name = "doctorId")
	private Doctor doctor;
	
	//ManyToMany
	@ManyToOne
    @JoinColumn(name = "userId")
	private User user;
	
	
	/*@ManyToMany(mappedBy="appointments")
	private List<User> user;*/
	
	public Appointments() {
		
	}

	public Appointments(Date createdDate, Date updatedDate,
			String problem,User userId, String status, LocalDate appointmentTime) {
		
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.problem = problem;
		this.status = status;
		this.appointmentTime = appointmentTime;
	}

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(LocalDate appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	public Date getPatientDOB() {
		return patientDOB;
	}

	public void setPatientDOB(Date patientDOB) {
		this.patientDOB = patientDOB;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Appointments [appointmentId=" + appointmentId + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + ", problem=" + problem + ", status=" + status + ", appointmentTime=" + appointmentTime
				+ ", patientName=" + patientName + ", patientGender=" + patientGender + ", patientDOB=" + patientDOB
				+ ", doctor=" + doctor + ", user=" + user + "]";
	}

	
	
	
	
	

}
