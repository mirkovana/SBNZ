package com.example.SBNZApp.facts;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Smestaj {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@Column(unique = true, nullable = false)
	private String naziv;
	
	@ManyToOne
	@JoinColumn(name = "destinacija_id")
	private Destinacija destinacija;
	
	public Smestaj() {}

	public Smestaj(Long iD, String naziv, Destinacija destinacija) {
		ID = iD;
		this.naziv = naziv;
		this.destinacija = destinacija;
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
}
