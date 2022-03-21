package com.passapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.passapp.models.Admin;

public interface AdminRepository extends JpaRepository<Admin,Long> {

	@Query("From Admin a WHERE a.username =:aAdminuser AND a.passowrd =:aPass")
	Admin getAdminByEmailAndPass(@Param("aAdminuser") String username, @Param("aPass") String pass);
	
}
