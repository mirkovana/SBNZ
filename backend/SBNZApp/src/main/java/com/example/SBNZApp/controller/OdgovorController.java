package com.example.SBNZApp.controller;


import javax.validation.Valid;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SBNZApp.facts.Karakteristika;
import com.example.SBNZApp.facts.Karakteristike;
import com.example.SBNZApp.facts.Odgovor;
import com.example.SBNZApp.facts.RegisteredUser;
import com.example.SBNZApp.service.KarakteristikaService;
import com.example.SBNZApp.service.UserService;

@RestController
@RequestMapping(value = "/odgovor")
public class OdgovorController {
	@Autowired
    private KieContainer kieContainer;
	
	@Autowired
    private UserService userService;
	
	@Autowired
    private KarakteristikaService karakteristikaService;
	
	
	@PostMapping(path = "/nesto/{id}", consumes = "application/json")
    public ResponseEntity<?> kupiOdgovore(@Valid @RequestBody Odgovor odgovor, @PathVariable Long id){//@Valid @RequestBody Odgovor odgovor
        KieSession kieSession = kieContainer.newKieSession();

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = authentication.getName();
        //-----------------------------------------------------------------------------------------------
        RegisteredUser user  = (RegisteredUser)userService.get(id);

        kieSession.insert(user);
        kieSession.insert(odgovor);

        kieSession.getAgenda().getAgendaGroup("questions").setFocus();
        kieSession.fireAllRules();
        kieSession.dispose();
        for(String k : user.getKar()) {
        	Karakteristike kkk =Karakteristike.valueOf(k);
        	Karakteristika ka = karakteristikaService.findByNaziv(kkk);
        	user.getPreferences().add(ka);
        }
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
