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

import com.example.SBNZApp.dto.SmestajDTO;
import com.example.SBNZApp.facts.Destinacija;
import com.example.SBNZApp.facts.Putovanje;
import com.example.SBNZApp.facts.RegisteredUser;
import com.example.SBNZApp.facts.Smestaj;
import com.example.SBNZApp.facts.TrenutniUser;
import com.example.SBNZApp.facts.User;
import com.example.SBNZApp.service.SmestajService;
import com.example.SBNZApp.service.UserService;

@RestController
@RequestMapping(value = "/smestaj")
public class SmestajController {

	@Autowired
	private KieContainer kieContainer;

	@Autowired
	private UserService userService;
	
	@Autowired
	private SmestajService smestajService;

	//@GetMapping(value = "/slican/{id}")
	public TrenutniUser nadjiSlicne(Long id) {
		KieSession kieSession = kieContainer.newKieSession();

		RegisteredUser user = (RegisteredUser) userService.get(id);
		User admin = userService.get(1L);

		List<RegisteredUser> sviRegistovani = new ArrayList<>();
		List<User> sviKorisnici = userService.listAll();
		sviKorisnici.remove(admin);
		for (User u : sviKorisnici) {
			sviRegistovani.add((RegisteredUser) u);
		}
		// izbacujemo trenutnog
		sviRegistovani.remove(user);

		for (RegisteredUser r : sviRegistovani) {
			kieSession.insert(r);
		}
		TrenutniUser trenutni = new TrenutniUser(user.getGodiste(), user.getPol(), user.getTipLjubimca(),
				user.getRadniStatus(), user.getTrenutnaDestinacija());
		kieSession.insert(trenutni);

		kieSession.getAgenda().getAgendaGroup("slican").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		return trenutni;
	}

	@GetMapping(value = "/ocena/{id}")
	public ResponseEntity<List<SmestajDTO>> nadjiPoOceni(@PathVariable Long id) {
		TrenutniUser trenutni = nadjiSlicne(id);
		KieSession kieSession = kieContainer.newKieSession();

		for (RegisteredUser r : trenutni.getSlicni()) {
			for(Putovanje p : r.getPutovanja()) {
				kieSession.insert(p);
			}
		}
		kieSession.insert(trenutni);

		kieSession.getAgenda().getAgendaGroup("ocena").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		
		List<SmestajDTO> dto = new ArrayList<>();
		for(Smestaj s: trenutni.getPreporuceniSmestaj()) {
			dto.add(new SmestajDTO(s));
		}

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/svi/{id}")
	public ResponseEntity<List<SmestajDTO>> nadjiSveSmestaje(@PathVariable Long id) {
		RegisteredUser user = (RegisteredUser) userService.get(id); 
		Destinacija destinacija = user.getTrenutnaDestinacija();
		List<SmestajDTO> dto = new ArrayList<>();
		List<Smestaj> listaSmestaja = smestajService.findAllByDestinacija(destinacija);
		
		for(Smestaj s: listaSmestaja) {
			dto.add(new SmestajDTO(s));
		}

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}
