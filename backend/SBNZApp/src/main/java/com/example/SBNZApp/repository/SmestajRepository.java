package com.example.SBNZApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SBNZApp.facts.Destinacija;
import com.example.SBNZApp.facts.Smestaj;

public interface SmestajRepository extends JpaRepository<Smestaj, Long>{

	List<Smestaj> findAllByDestinacija(Destinacija destinacija);
}
