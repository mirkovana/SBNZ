package com.example.SBNZApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SBNZApp.facts.Destinacija;
import com.example.SBNZApp.repository.DestinacijaRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Service
public class DestinacijaService {
	
	@Autowired
	private DestinacijaRepository repo;
	
	@JsonIgnore
	public List<Destinacija> listAll() {
		return repo.findAll();
	}

	public Destinacija save(Destinacija destinacija) {
		return repo.save(destinacija);
	}

	public Destinacija get(Long id) {
		return repo.findById(id).get();
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

}
