package com.example.SBNZApp.facts;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Karakteristika {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@Column(unique = true, nullable = false)
	@Enumerated(EnumType.STRING)
	private Karakteristike naziv;
	
	public Karakteristika() {
	}

	public Karakteristika(Long iD, Karakteristike naziv) {
		ID = iD;
		this.naziv = naziv;
	}
	
	public Karakteristika(Karakteristike naziv) {
 
		this.naziv = naziv;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Karakteristike getNaziv() {
		return naziv;
	}

	public void setNaziv(Karakteristike naziv) {
		this.naziv = naziv;
	}
}
