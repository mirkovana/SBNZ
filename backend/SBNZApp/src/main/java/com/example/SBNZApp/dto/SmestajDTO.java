package com.example.SBNZApp.dto;

import com.example.SBNZApp.facts.Smestaj;

public class SmestajDTO {
	private Long id;
	private String naziv;
	private String opis;
	private String lokacija;
	private String destinacija;
	
	public SmestajDTO() {
	}
	
	public SmestajDTO(Smestaj smestaj) {
		this.id = smestaj.getID();
		this.naziv = smestaj.getNaziv();
		this.opis = smestaj.getOpis();
		this.lokacija = smestaj.getLokacija();
		this.destinacija = smestaj.getDestinacija().getNaziv();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getLokacija() {
		return lokacija;
	}
	public void setLokacija(String lokacija) {
		this.lokacija = lokacija;
	}
	public String getDestinacija() {
		return destinacija;
	}
	public void setDestinacija(String destinacija) {
		this.destinacija = destinacija;
	}
	
	

}
