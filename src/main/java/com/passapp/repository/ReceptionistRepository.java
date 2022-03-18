package com.passapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.passapp.models.Receptionist;

public interface ReceptionistRepository extends JpaRepository<Receptionist,Long> {

}
