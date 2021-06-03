package com.example.SBNZApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SBNZApp.facts.Smestaj;
import com.example.SBNZApp.repository.SmestajRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Service
public class SmestajService {
	
	@Autowired
	private SmestajRepository repo;
	
	@JsonIgnore
	public List<Smestaj> listAll() {
		return repo.findAll();
	}

	public Smestaj save(Smestaj smestaj) {
		return repo.save(smestaj);
	}

	public Smestaj get(Long id) {
		return repo.findById(id).get();
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
}
