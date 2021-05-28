package com.example.SBNZApp.dto;

public class DestinacijaDTO {
	private String naziv;
	
	public DestinacijaDTO() {
	}

	public DestinacijaDTO(String naziv) {
		this.naziv = naziv;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
}
