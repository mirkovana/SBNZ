package sbnz.integracija.example.facts;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private String naziv;
	
	public Karakteristika() {
	}

	public Karakteristika(Long iD, String naziv) {
		ID = iD;
		this.naziv = naziv;
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
}
