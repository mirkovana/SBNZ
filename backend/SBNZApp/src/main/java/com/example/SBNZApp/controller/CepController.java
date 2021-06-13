package com.example.SBNZApp.controller;

import java.time.LocalDate;
import java.util.Collection;

import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SBNZApp.facts.AlarmTriggered;
import com.example.SBNZApp.facts.Putovanje;
import com.example.SBNZApp.facts.PutovanjeEvent;
import com.example.SBNZApp.facts.RegisteredUser;
import com.example.SBNZApp.facts.Smestaj;
import com.example.SBNZApp.facts.SmestajAlarm;
import com.example.SBNZApp.service.EmailSender;
import com.example.SBNZApp.service.PutovanjeService;
import com.example.SBNZApp.service.SmestajService;
import com.example.SBNZApp.service.UserService;

@RestController
@RequestMapping(value = "/cep")
public class CepController {
	
	@Autowired
	private KieSession kieSession;
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private EmailSender emailSender;
	
	@Autowired
	private SmestajService smestajService;
	
	@Autowired
	private PutovanjeService putovanjeService;
	
	@PostMapping(value = "/napadNaSmestaj/{id}/{idSmestaja}")
	public ResponseEntity<?> napadNaSmestaj(@PathVariable Long id, @PathVariable Long idSmestaja) {
		RegisteredUser user = (RegisteredUser) userService.get(id);
		SmestajAlarm smestajAlarm = new SmestajAlarm();
		PutovanjeEvent pe = new PutovanjeEvent(user);
		kieSession.insert(pe);
		kieSession.setGlobal("smestajAlarm", smestajAlarm);
		kieSession.getAgenda().getAgendaGroup("cep").setFocus();
		kieSession.fireAllRules();
		System.out.println("SMESTAJ "+smestajAlarm.getUserId());
		System.out.println("USER "+user.getID());
		if(smestajAlarm.getUserId() == user.getID()) {
			emailSender.slanjeUpozorenja(user.getUsername());
		}else {
			Smestaj smestaj = smestajService.get(idSmestaja);
			LocalDate datum = LocalDate.now();
			Putovanje putovanje = new Putovanje(smestaj, user, 0, datum);
			putovanjeService.save(putovanje);	
		}
		
		Collection<?> newEvents = kieSession.getObjects(new ClassObjectFilter(AlarmTriggered.class));
        if(newEvents.size()==1) {
        	emailSender.slanjeUpozorenjaAdminu(user.getUsername());
        }
        
        
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
