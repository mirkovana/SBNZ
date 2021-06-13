package com.example.SBNZApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SBNZApp.facts.Destinacija;
import com.example.SBNZApp.facts.Karakteristika;
import com.example.SBNZApp.facts.Karakteristike;

public interface DestinacijaRepository extends JpaRepository<Destinacija, Long>{
	Destinacija findByNaziv(String naziv);


}
