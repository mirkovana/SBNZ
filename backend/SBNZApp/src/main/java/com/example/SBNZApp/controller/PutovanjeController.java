package com.example.SBNZApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SBNZApp.dto.PutovanjeDTO;
import com.example.SBNZApp.facts.Putovanje;
import com.example.SBNZApp.service.PutovanjeService;

@RestController
@RequestMapping(value = "/putovanja")
public class PutovanjeController {
	
	@Autowired
	private PutovanjeService putovanjeService;
	
	@GetMapping(value = "/svaPutovanja/{idKorisnika}")
	public ResponseEntity<List<PutovanjeDTO>> izlistajSvaPutovanja(@PathVariable Long idKorisnika) {
		List<PutovanjeDTO> korisnikovaPutovanje = new ArrayList<PutovanjeDTO>();
		List<Putovanje> svaPutovanja = putovanjeService.listAll();
		for(Putovanje p : svaPutovanja) {
			if(p.getGost().getID() == idKorisnika) {
				korisnikovaPutovanje.add(new PutovanjeDTO(p));
			}
		}
		return new ResponseEntity<List<PutovanjeDTO>>(korisnikovaPutovanje, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping(value = "/oceni/{idPutovanja}/{ocena}")
	public ResponseEntity<?> oceniPutovanje(@PathVariable Long idPutovanja, @PathVariable int ocena) {
		Putovanje putovanje = putovanjeService.get(idPutovanja);
		putovanje.setOcena(ocena);
		putovanjeService.save(putovanje);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
