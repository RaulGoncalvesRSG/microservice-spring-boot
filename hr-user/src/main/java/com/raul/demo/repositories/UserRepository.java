package com.raul.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raul.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}