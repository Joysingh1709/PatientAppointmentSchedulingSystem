package com.passapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.passapp.models.User;

public interface UserLoginRepository extends JpaRepository<User,Long> {

}
