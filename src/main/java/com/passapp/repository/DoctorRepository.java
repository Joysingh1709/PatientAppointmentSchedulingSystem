package com.passapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.passapp.models.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

}
