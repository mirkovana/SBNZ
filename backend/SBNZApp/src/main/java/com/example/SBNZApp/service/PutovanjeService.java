package com.example.SBNZApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SBNZApp.facts.Destinacija;
import com.example.SBNZApp.facts.Putovanje;
import com.example.SBNZApp.repository.PutovanjeRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Service
public class PutovanjeService {
	
	@Autowired
	private PutovanjeRepository repo;
	
	@JsonIgnore
	public List<Putovanje> listAll() {
		return repo.findAll();
	}

	public Putovanje save(Putovanje putovanje) {
		return repo.save(putovanje);
	}

	public Putovanje get(Long id) {
		return repo.findById(id).get();
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

}
