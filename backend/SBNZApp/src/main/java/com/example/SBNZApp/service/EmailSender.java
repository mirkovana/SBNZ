package com.example.SBNZApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

	@Autowired
	private JavaMailSender javaMailSender;

	@Async
	public void slanjeUpozorenja(String recipient) {
		System.out.println("Slanje emaila...");

		SimpleMailMessage email = new SimpleMailMessage();
		String tekstMaila = "Uoceno je sumnjivo ponasanje na Vasem nalogu - spam aktivnosti."; 
		
		email.setTo(recipient);
 
		email.setSubject("Upozorenje");
		 

		email.setText(tekstMaila);
		
	 

		javaMailSender.send(email);  
		System.out.println("Email poslat!");

	}
	
	@Async
	public void slanjeUpozorenjaAdminu(String user) {
		System.out.println("Slanje emaila...");

		SimpleMailMessage email = new SimpleMailMessage();
		String tekstMaila = "Uoceno je sumnjivo ponasanje na nalogu sa korisnickim imenom: " +user+" - spam aktivnosti."; 
		
		email.setTo("mana81098@gmail.com");
 
		email.setSubject("Upozorenje");
		 

		email.setText(tekstMaila);
		
	 

		javaMailSender.send(email);  
		System.out.println("Email poslat!");

	}
}
