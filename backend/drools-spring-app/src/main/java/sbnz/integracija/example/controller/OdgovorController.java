package sbnz.integracija.example.controller;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.facts.Odgovor;

@RestController
@RequestMapping(value = "/odgovor")
public class OdgovorController {
	@Autowired
    private KieContainer kieContainer;
	
	@PostMapping(path = "/nesto")
    public ResponseEntity<?> kupiOdgovore(@RequestBody Odgovor odgovor){

        KieSession kieSession = kieContainer.newKieSession();

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = authentication.getName();
        //-----------------------------------------------------------------------------------------------
//        User user  = userRepository.findByUsername(currentPrincipalName);
//        user.setUser_characteristics(chars);
//        userRepository.save(user);
//        kieSession.insert(user);
//
//        List<Tank> tanks = tankRepository.findAll();
//        for (Tank tank: tanks) {
//            kieSession.insert(tank);
//        }
//
//        kieSession.getAgenda().getAgendaGroup("playstyle").setFocus();
//        kieSession.fireAllRules();
//
//        userRepository.save(user);
//
//        kieSession.dispose();
//
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
