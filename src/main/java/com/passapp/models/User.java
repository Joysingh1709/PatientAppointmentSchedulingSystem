package com.passapp.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue
	private Long userId;
	private String email;
	private String password;
	private String name;
	private String gender;
	private Date dob;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable (name = "user_appointments", joinColumns = { @JoinColumn(name = "userId") }, 
	inverseJoinColumns = {@JoinColumn(name = "appointmentId")})
	private List<Appointments> appointments;
		//List <> familyMembers;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
		public User(String email, String password, String name, String gender, Date dob,
				List<Appointments> appointments) {
			
			this.email = email;
			this.password = password;
			this.name = name;
			this.gender = gender;
			this.dob = dob;
			this.appointments = appointments;
		}
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public Date getDob() {
			return dob;
		}
		public void setDob(Date dob) {
			this.dob = dob;
		}
		public List<Appointments> getAppointments() {
			return appointments;
		}
		public void setAppointments(List<Appointments> appointments) {
			this.appointments = appointments;
		}
		@Override
		public String toString() {
			return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", name=" + name
					+ ", gender=" + gender + ", dob=" + dob + ", appointments=" + appointments + "]";
		}
	
	
	
	
	

}
