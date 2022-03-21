package com.passapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.passapp.models.User;

public interface PatientRepository extends JpaRepository<User,Long> {
  @Query ("From User p WHERE p.email =:pEmail AND p.password =:pPassword")
  User getPatientByEmailAndPassword(@Param("pEmail") String email, @Param("pPass") String password);
	
}
