package com.passapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.passapp.models.Appointments;

public interface AppointmentRepository extends JpaRepository<Appointments, Long>{

}
