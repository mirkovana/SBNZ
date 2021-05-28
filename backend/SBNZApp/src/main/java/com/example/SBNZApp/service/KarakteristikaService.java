package com.example.SBNZApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SBNZApp.facts.Karakteristika;
import com.example.SBNZApp.facts.Karakteristike;
import com.example.SBNZApp.repository.KarakteristikaRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Service
public class KarakteristikaService {
	
	@Autowired
	private KarakteristikaRepository repo;
	
	@JsonIgnore
	public List<Karakteristika> listAll() {
		return repo.findAll();
	}

	public Karakteristika save(Karakteristika karakteristika) {
		return repo.save(karakteristika);

	}

	public Karakteristika get(Long id) {
		return repo.findById(id).get();
	}
	
	public Karakteristika findByNaziv(Karakteristike naziv) {
		return repo.findByNaziv(naziv);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
}
