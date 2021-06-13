package com.example.SBNZApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SBNZApp.dto.UserDTO;
import com.example.SBNZApp.facts.RegisteredUser;
import com.example.SBNZApp.facts.TipKorisnika;
import com.example.SBNZApp.facts.User;
import com.example.SBNZApp.service.UserService;

@RestController
@RequestMapping(value = "/izvestaj")
public class IzvestajController {
	@Autowired
    private UserService userService;
	
	@Autowired
	private KieSession kieSession;

	//POZIV PRAVILA
	public ResponseEntity<?> postaviNeaktivnog(Long id) {
		RegisteredUser user = (RegisteredUser) userService.get(id);

		kieSession.insert(user);

		kieSession.getAgenda().getAgendaGroup("neaktivni").setFocus();
		kieSession.fireAllRules();
		//kieSession.dispose();
		userService.save(user);

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//ENDPOINT
	@GetMapping(value = "/neaktivan")
	public ResponseEntity<List<UserDTO>> postaviNeaktivnogKorisnika() {
		User admin = userService.get(1L);

		 
		List<User> korisnici = userService.listAll();
		korisnici.remove(admin);
		
		for(User u : korisnici) {
			postaviNeaktivnog(u.getID());
		}
		List<User> povratniKorisnici = userService.listAll();
		povratniKorisnici.remove(admin);
		List<UserDTO> dto = new ArrayList<>();
		List<RegisteredUser> reg = new ArrayList<>();
		for(User u : povratniKorisnici) {
			reg.add((RegisteredUser)u);
			
		}
		for(RegisteredUser r : reg) {
			if(r.getTipKorisnika() == TipKorisnika.NEAKTIVNI) {
				dto.add(new UserDTO(r));
			}
			
		}
		
 
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	
	//POZIV PRAVILA
	public ResponseEntity<?> postaviPremium(Long id) {
		RegisteredUser user = (RegisteredUser) userService.get(id);

		kieSession.insert(user);

		kieSession.getAgenda().getAgendaGroup("premium").setFocus();
		kieSession.fireAllRules();
		//kieSession.dispose();
		userService.save(user);

		return new ResponseEntity<>(HttpStatus.OK);
	}
	//ENDPOINT KOJI GADJAMO
	@GetMapping(value = "/premium")
	public ResponseEntity<List<UserDTO>> postaviPremiumKorisnika() {
		User admin = userService.get(1L);

		 
		List<User> korisnici = userService.listAll();
		korisnici.remove(admin);
		
		for(User u : korisnici) {
			postaviPremium(u.getID());
		}
		List<User> povratniKorisnici = userService.listAll();
		List<RegisteredUser> reg = new ArrayList<>();
		povratniKorisnici.remove(admin);
		List<UserDTO> dto = new ArrayList<>();
		
		
		for(User u : povratniKorisnici) {
			reg.add((RegisteredUser)u);
			
		}
		for(RegisteredUser r : reg) {
			if(r.getTipKorisnika() == TipKorisnika.PREMIUM) {
				dto.add(new UserDTO(r));
			}
			
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}
