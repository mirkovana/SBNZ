package com.example.SBNZApp.facts;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Putovanje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@ManyToOne
	@JoinColumn(name = "idSmestaja", referencedColumnName = "ID", nullable = true)
	private Smestaj smestaj;
	
	@ManyToOne
	@JoinColumn(name = "idGosta", referencedColumnName = "ID", nullable = true)
	private RegisteredUser gost;
	
	@Column
	private LocalDate datum;
	
	@Column
	private int ocena;
	
	public Putovanje() {
	}

	public Putovanje(Long iD, Smestaj smestaj, RegisteredUser gost, LocalDate datum, int ocena) {
		ID = iD;
		this.smestaj = smestaj;
		this.gost = gost;
		this.datum = datum;
		this.ocena = ocena;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Smestaj getSmestaj() {
		return smestaj;
	}

	public void setSmestaj(Smestaj smestaj) {
		this.smestaj = smestaj;
	}

	public RegisteredUser getGost() {
		return gost;
	}

	public void setGost(RegisteredUser gost) {
		this.gost = gost;
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
}
