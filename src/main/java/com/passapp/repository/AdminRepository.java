package com.passapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.passapp.models.Admin;

public interface AdminRepository extends JpaRepository<Admin,Long> {

}
