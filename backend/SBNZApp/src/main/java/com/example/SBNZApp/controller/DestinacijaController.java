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

import com.example.SBNZApp.dto.DestinacijaDTO;
import com.example.SBNZApp.facts.Destinacija;
import com.example.SBNZApp.facts.RegisteredUser;
import com.example.SBNZApp.facts.TrenutniUser;
import com.example.SBNZApp.facts.User;
import com.example.SBNZApp.service.DestinacijaService;
import com.example.SBNZApp.service.KarakteristikaService;
import com.example.SBNZApp.service.UserService;

@RestController
@RequestMapping(value = "/destinacija")
public class DestinacijaController {
	@Autowired
    private KieContainer kieContainer;
	
	@Autowired
    private UserService userService;
	
	@Autowired
    private KarakteristikaService karakteristikaService;
	
	@Autowired
    private DestinacijaService destinacijaService;
	
	
	@GetMapping(value = "/nesto/{id}")
    public ResponseEntity<DestinacijaDTO> prikaziDestinaciju(@PathVariable Long id){
		KieSession kieSession = kieContainer.newKieSession();

//      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//      String currentPrincipalName = authentication.getName();
      //-----------------------------------------------------------------------------------------------
      RegisteredUser user  = (RegisteredUser)userService.get(id);
      
      List<Destinacija> destinacije = destinacijaService.listAll();
      for(Destinacija d : destinacije) {
    	  kieSession.insert(d);
      }
      kieSession.insert(user);


      kieSession.getAgenda().getAgendaGroup("destinacije").setFocus();
      kieSession.fireAllRules();
      kieSession.dispose();
      userService.save(user);
      DestinacijaDTO ddto = new DestinacijaDTO(user.getTrenutnaDestinacija().getNaziv());
	  return new ResponseEntity<>(ddto,HttpStatus.OK);
	}
}
