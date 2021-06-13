package com.example.SBNZApp.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SBNZApp.dto.UserDTO;
import com.example.SBNZApp.dto.UserLoginDTO;
import com.example.SBNZApp.dto.UserTokenStateDTO;
import com.example.SBNZApp.facts.LoginAlarm;
import com.example.SBNZApp.facts.PokusajLoginaEvent;
import com.example.SBNZApp.facts.RegisteredUser;
import com.example.SBNZApp.facts.User;
import com.example.SBNZApp.security.TokenUtils;
import com.example.SBNZApp.service.AuthorityService;
import com.example.SBNZApp.service.CustomUserDetailsService;
import com.example.SBNZApp.service.UserService;
import com.example.SBNZApp.service.VerificationTokenService;


//Kontroler zaduzen za autentifikaciju korisnika
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@Autowired
	@Lazy
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@Autowired
	private VerificationTokenService verificationTokenService;
	
	@Autowired
	private KieSession kieSession;

	// private UserMapper userMapper;

	// Prvi endpoint koji pogadja korisnik kada se loguje.
	// Tada zna samo svoje korisnicko ime i lozinku i to prosledjuje na backend.
	@PostMapping("/log-in")
	public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody UserLoginDTO authenticationRequest,
			HttpServletResponse response) {

		//dobavimo usera preko tog userdto 
		//proverimo da li je aktivan 
		//ako jeste nastavi dalje kao sto si  do sad
		//ako nije onda ona poruka 
		try {
			User userReg =  userService.findByUsername(authenticationRequest.getUsername());
					Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
							authenticationRequest.getUsername(), authenticationRequest.getPassword()));

					// Ubaci korisnika u trenutni security kontekst
					SecurityContextHolder.getContext().setAuthentication(authentication);

					// Kreiraj token za tog korisnika
					User user = (User) authentication.getPrincipal();
					String jwt = tokenUtils.generateToken(user.getUsername()); // prijavljujemo se na sistem sa email adresom
					int expiresIn = tokenUtils.getExpiredIn();

					// Vrati token kao odgovor na uspesnu autentifikaciju
					return ResponseEntity.ok(new UserTokenStateDTO(jwt, expiresIn, user.getID()));
		}catch(Exception e) {
			User user = userService.findByUsername(authenticationRequest.getUsername());
			if(user != null) {
				LoginAlarm loginAlarm = new LoginAlarm();
				PokusajLoginaEvent event = new PokusajLoginaEvent(user);
				
				kieSession.setGlobal("loginAlarm", loginAlarm);
				kieSession.getAgenda().getAgendaGroup("pokusajLogina").setFocus();
				kieSession.insert(event);
				kieSession.fireAllRules();
				
				if(loginAlarm.getUserID() == user.getID()) {
					System.out.println("Tri pokusaja logina sa pogresnim kredencijalima od strane jednog korisnika");
				}
			}
			return new ResponseEntity<>("Incorrect username or password.", HttpStatus.BAD_REQUEST);
		}		
	}

	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/logout")
	public ResponseEntity logOut(HttpServletRequest request) {
		SecurityContextHolder.getContext().setAuthentication(null);
		return new ResponseEntity(HttpStatus.OK);
	}

	// Endpoint za registraciju novog korisnika
	@PostMapping("/sign-up")
	public ResponseEntity<?> addUser(@Valid @RequestBody UserDTO usersDTO, HttpServletRequest request) throws Exception {

		User existUser = this.userService.findByUsername(usersDTO.getUsername());
		if (existUser != null) {
			throw new Exception("Username already exists");
		}
		RegisteredUser user = new RegisteredUser();
		try {

			user.setName(usersDTO.getName());

			if (usersDTO.getPassword().isEmpty()) {
				//throw new Exception("Password cannot be empty");
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			user.setPassword(passwordEncoder.encode(usersDTO.getPassword()));
			user.setSurname(usersDTO.getSurname());
			user.setUsername(usersDTO.getUsername());
			user.setGodiste(usersDTO.getGodiste());
			user.setPol(usersDTO.getPol());
			user.setRadniStatus(usersDTO.getRadniStatus());
			user.setTipLjubimca(usersDTO.getTipLjubimca());
			user.setVakcinacija(usersDTO.getVakcinacija());
			if (usersDTO.getUsername().isEmpty()) {
				//throw new Exception("Username cannot be empty");
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			user.setUsername(usersDTO.getUsername());
			//user.setAuthorities(authorityService.findByName("ROLE_USER")); //OVO TEK KAD POTVRDI MEJL ADRESU
			user = (RegisteredUser) userService.save(user);
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(new UserDTO(user), HttpStatus.CREATED);
	}
}
