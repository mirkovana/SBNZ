package com.example.SBNZApp.facts;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Smestaj {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	@Column(unique = true, nullable = false)
	private String naziv;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "smestaj")
	@JsonBackReference
	private List<Putovanje> putovanja = new ArrayList<Putovanje>();

	@ManyToOne
	@JoinColumn(name = "destinacija_id")
	private Destinacija destinacija;

	@Column
	private String lokacija;

	@Column
	private String opis;

	public Smestaj() {
	}

	public Smestaj(Long iD, String naziv, Destinacija destinacija, String lokacija, String opis) {
		ID = iD;
		this.naziv = naziv;
		this.destinacija = destinacija;
		this.lokacija = lokacija;
		this.opis = opis;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Destinacija getDestinacija() {
		return destinacija;
	}

	public void setDestinacija(Destinacija destinacija) {
		this.destinacija = destinacija;
	}

	public List<Putovanje> getPutovanja() {
		return putovanja;
	}

	public void setPutovanja(List<Putovanje> putovanja) {
		this.putovanja = putovanja;
	}

	public String getLokacija() {
		return lokacija;
	}

	public void setLokacija(String lokacija) {
		this.lokacija = lokacija;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
}
