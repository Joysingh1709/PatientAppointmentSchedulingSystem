package com.passapp;

import javax.transaction.Transactional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.passapp.exceptions.AdminNotFoundException;
import com.passapp.models.Admin;
import com.passapp.services.AdminService;
@SpringBootTest(classes = PatientappointmentschedulingappApplication.class)
@Transactional
@Rollback(true)
public class AdminTest {
	
	@Autowired
	private AdminService adminService;
	
	public Admin addAdmin(){
		Admin admin = new Admin();
		admin.setUserName("Rohit");
		admin.setPassword("jayesh");
		Long id =  adminService.addAdmin(admin).getAdminId();
		return adminService.getAdminById(id);
	}
	

	@Test
	public void testAddAdmin() {
		Admin admin = addAdmin();
		assertEquals("Rohit", admin.getUserName());
		assertEquals("jayesh",admin.getPassword());
	}
	
	
	@Test
	public void testUpdateAdmin(){
		Admin admin = addAdmin();
		admin.setUserName("Kumar");
		adminService.updateAdmin(admin);
		assertEquals("Kumar",adminService.getAdminById(admin.getAdminId()).getUserName());
	}
	
	
	@Test
	public void testDeleteAdmin(){
		Admin admin = addAdmin();
		adminService.deleteAdmin(admin);
		assertThrows(AdminNotFoundException.class, ()->{
			adminService.getAdmin(admin.getName(),admin.getPassword());
			});
	}
}