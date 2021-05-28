package com.example.SBNZApp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SBNZApp.facts.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
