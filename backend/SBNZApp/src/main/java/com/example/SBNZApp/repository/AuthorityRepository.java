package com.example.SBNZApp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SBNZApp.facts.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Authority findByName(String name);
}
