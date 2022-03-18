package com.passapp.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
	//private Doctor doctorId;
	//private User userId;
	private String problem;
	private String status;
	private LocalDate appointmentTime;
	
	@ManyToOne
    @JoinColumn(name = "doctorId")
	private Doctor doctor;
	
	@ManyToOne
    @JoinColumn(name = "receptionistId")
	private Receptionist receptionist;
	
	@ManyToMany(mappedBy="appointments")
	private List<User> user;
	
	public Appointments() {
		// TODO Auto-generated constructor stub
	}

	public Appointments(Date createdDate, Date updatedDate,
			String problem, String status, LocalDate appointmentTime) {
		
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		//this.doctorId = doctorId;
		//this.userId = userId;
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

	/*public Doctor getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Doctor doctorId) {
		this.doctorId = doctorId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}*/

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

	@Override
	public String toString() {
		return "Appointments [appointmentId=" + appointmentId + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + ", doctorId=" +  ", userId=" + ", problem=" + problem + ", status="
				+ status + ", appointmentTime=" + appointmentTime + "]";
	}
	
	
	
	

}
