package com.passapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="receptionist")
public class Receptionist {
	
	@Id
	@GeneratedValue
	private Long receptionistId;
	private String email;
	private String password;
	
	
	
	
	public Receptionist() {
		// TODO Auto-generated constructor stub
	}
	
	public Receptionist(String email, String password) {
		
		this.email = email;
		this.password = password;
	}

	public Long getReceptionistId() {
		return receptionistId;
	}

	public void setReceptionistId(Long receptionistId) {
		this.receptionistId = receptionistId;
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



	@Override
	public String toString() {
		return "Receptionist [receptionistId=" + receptionistId + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	

}
