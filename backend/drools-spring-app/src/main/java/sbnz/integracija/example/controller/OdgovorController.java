package sbnz.integracija.example.controller;

import javax.validation.Valid;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.facts.Karakteristike;
import sbnz.integracija.example.facts.Odgovor;
import sbnz.integracija.example.facts.RegisteredUser;
import sbnz.integracija.example.service.UserService;

@RestController
@RequestMapping(value = "/odgovor")
public class OdgovorController {
	@Autowired
    private KieContainer kieContainer;
	
	@Autowired
    private UserService userService;
	
	
	@PostMapping(path = "/nesto", consumes = "application/json")
    public ResponseEntity<?> kupiOdgovore(@Valid @RequestBody Odgovor odgovor){//@Valid @RequestBody Odgovor odgovor
		Karakteristike karakteristike = Karakteristike.Mir;
//        Odgovor odgovor = new Odgovor();
//        odgovor.setMir(true);
        KieSession kieSession = kieContainer.newKieSession();

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = authentication.getName();
        //-----------------------------------------------------------------------------------------------
        RegisteredUser user  = (RegisteredUser)userService.findByUsername("kor1@nesto.com");
//        user.setUser_characteristics(chars);
//        userRepository.save(user);
        kieSession.insert(user);
        kieSession.insert(odgovor);
        kieSession.insert(karakteristike);
//
//        List<Tank> tanks = tankRepository.findAll();
//        for (Tank tank: tanks) {
//            kieSession.insert(tank);
//        }
//
        kieSession.getAgenda().getAgendaGroup("questions").setFocus();
        kieSession.fireAllRules();
        userService.save(user);
        kieSession.dispose();
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA "+user.getPreferences().size());
        System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB "+odgovor.isMir());
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
