package com.example.SBNZApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SBNZApp.facts.Karakteristika;
import com.example.SBNZApp.facts.Karakteristike;

public interface KarakteristikaRepository extends JpaRepository<Karakteristika, Long>{
	Karakteristika findByNaziv(Karakteristike naziv);

}
