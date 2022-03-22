package com.passapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.passapp.models.Appointments;
import com.passapp.models.User;

public interface PatientRepository extends JpaRepository<User, Long> {

	@Query("From User p WHERE p.email =:pEmail AND p.password =:pPass")
	User getPatientByEmailAndPassword(@Param("pEmail") String email, @Param("pPass") String password);

	@Query("From Appointments a WHERE a.user.userId = :aUserId")
	List<Appointments> getPatientAppointments(@Param("aUserId") Long userId);

}
