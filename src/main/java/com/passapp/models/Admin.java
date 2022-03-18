package com.passapp.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	
	@Id
	@GeneratedValue
	private Long adminId;
	private String name;
	private String userName;
	private String password;
	
	@OneToMany(targetEntity = Doctor.class, mappedBy = "admin", cascade = CascadeType.ALL) 
	private List<Doctor> doctor;
	
	@OneToOne
	@JoinColumn(name = "receptionistId")
	private Receptionist receptionist;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(String name, String userName, String password) {
		
		this.name = name;
		this.userName = userName;
		this.password = password;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", userName=" + userName + ", password=" + password
				+ "]";
	}
	
	
	
	
}
