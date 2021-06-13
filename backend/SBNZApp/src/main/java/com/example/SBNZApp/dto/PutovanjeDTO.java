package com.example.SBNZApp.dto;

import java.time.LocalDate;

import com.example.SBNZApp.facts.Putovanje;
import com.example.SBNZApp.facts.Smestaj;

public class PutovanjeDTO {
	
	private Long ID;
	private String smestaj;
	private LocalDate datum;
	private int ocena;
	
	public PutovanjeDTO(Putovanje putovanje) {
		ID = putovanje.getID();
		this.smestaj = putovanje.getSmestaj().getNaziv();
		this.datum = putovanje.getDatum();
		this.ocena = putovanje.getOcena();
	}
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getSmestaj() {
		return smestaj;
	}
	public void setSmestaj(String smestaj) {
		this.smestaj = smestaj;
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
