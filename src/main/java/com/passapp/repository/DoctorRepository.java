package com.passapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.passapp.models.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	@Query("FROM Doctor d where d.email=:dEmail AND d.password=:dPass")
	Doctor getDoctorByEmailAndPass(@Param("dEmail") String email, @Param("dPass") String pass);

	@Query("SELECT SUM(d.fee) FROM Doctor d")
	Double getTotalFee();
	
	@Query("From Doctor d WHERE d.status = :dStatus")
    List<Doctor> getActiveDoctor(@Param("dStatus") String status);
}
