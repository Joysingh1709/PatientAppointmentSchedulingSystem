package com.passapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.passapp.models.User;

public interface PatientRepository extends JpaRepository<User,Long> {

}
