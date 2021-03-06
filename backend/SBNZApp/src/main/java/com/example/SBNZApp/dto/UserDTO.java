package com.example.SBNZApp.dto;

import java.time.LocalDate;
import java.util.Date;

import com.example.SBNZApp.facts.RegisteredUser;
import com.example.SBNZApp.facts.TipKorisnika;
import com.example.SBNZApp.facts.RegisteredUser.Pol;
import com.example.SBNZApp.facts.RegisteredUser.RadniStatus;
import com.example.SBNZApp.facts.RegisteredUser.TipLjubimca;

public class UserDTO {
	private String name;
	private String surname;
	private int godiste;
	private Pol pol;
	private TipLjubimca tipLjubimca;
	private RadniStatus radniStatus;
	private LocalDate vakcinacija;
    private String username;
	private String password;
	private TipKorisnika tipKorisnika;
	private int popust;
	
	public UserDTO() {}
	
	public UserDTO(RegisteredUser user) {
		this.name = user.getName();
		this.surname = user.getSurname();
		this.godiste = user.getGodiste();
		this.pol = user.getPol();
		this.tipLjubimca = user.getTipLjubimca();
		this.radniStatus = user.getRadniStatus();
		this.vakcinacija = user.getVakcinacija();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.tipKorisnika = user.getTipKorisnika();
		this.popust =user.getPopust();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getGodiste() {
		return godiste;
	}

	public void setGodiste(int godiste) {
		this.godiste = godiste;
	}

	public Pol getPol() {
		return pol;
	}

	public void setPol(Pol pol) {
		this.pol = pol;
	}

	public TipLjubimca getTipLjubimca() {
		return tipLjubimca;
	}

	public void setTipLjubimca(TipLjubimca tipLjubimca) {
		this.tipLjubimca = tipLjubimca;
	}

	public RadniStatus getRadniStatus() {
		return radniStatus;
	}

	public void setRadniStatus(RadniStatus radniStatus) {
		this.radniStatus = radniStatus;
	}

	public LocalDate getVakcinacija() {
		return vakcinacija;
	}

	public void setVakcinacija(LocalDate vakcinacija) {
		this.vakcinacija = vakcinacija;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TipKorisnika getTipKorisnika() {
		return tipKorisnika;
	}

	public void setTipKorisnika(TipKorisnika tipKorisnika) {
		this.tipKorisnika = tipKorisnika;
	}

	public int getPopust() {
		return popust;
	}

	public void setPopust(int popust) {
		this.popust = popust;
	}
}
