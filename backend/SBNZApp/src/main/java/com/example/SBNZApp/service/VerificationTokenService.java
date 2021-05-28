package com.example.SBNZApp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SBNZApp.facts.RegisteredUser;
import com.example.SBNZApp.facts.VerificationToken;
import com.example.SBNZApp.repository.VerificationTokenRepository;
@Service
public class VerificationTokenService {
	
	@Autowired 
	private VerificationTokenRepository verificationTokenRepository;
	
	
	public VerificationToken save(VerificationToken token) {
		return verificationTokenRepository.save(token);
	}
	
	public VerificationToken findByToken(String token) {
		return verificationTokenRepository.findByToken(token);
	}
	public VerificationToken findByRegisteredUser(RegisteredUser registeredUser) {
		return verificationTokenRepository.findByRegisteredUser(registeredUser);
	}	
}
